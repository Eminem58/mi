package com.mi.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.mi.lock.RedisLock;
import com.mi.sys.entity.KillGoodsPrice;
import com.mi.sys.mapper.KillGoodsPriceMapper;
import com.mi.sys.mapper.OrderKillMapper;
import com.mi.sys.service.IKillByQueueService;
import com.mi.sys.service.IKillService;
import com.mi.sys.vo.KiilBeanVO;
import com.mi.sys.vo.KillGoodsPriceDetailVO;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 金彪
 * @date 2021-01-20
 */
@Service
@Slf4j
public class KillServiceImpl implements IKillService {

    /**
     * 秒杀商品表
     */
    @Resource
    private KillGoodsPriceMapper killGoodsPriceMapper;
    /**
     * 秒杀订单表
     */
    @Resource
    private OrderKillMapper orderKillMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 本地缓存ehcache
     */
    @Autowired
    private CacheManager cacheManager;
    @Resource
    private IKillByQueueService killByQueueService;

    /**
     * 预扣库存lua脚本
     */
    private static final String STOCK_LUA;
    private static final String STOCK_LUA_1;
    private static final String STOCK_LUA_INCR;
    private static String REDIS_LOCK = "stock";

    static {
        /**
         * @desc 扣减库存Lua脚本
         * 库存（stock）-1：表示不限库存
         * 库存（stock）0：表示没有库存
         * 库存（stock）大于0：表示剩余库存
         *
         * @params 库存key
         * @return
         * 		-3:库存未初始化
         * 		-2:库存不足
         * 		-1:不限库存
         * 		大于等于0:剩余库存（扣减之后剩余的库存）
         * 	    redis缓存的库存(value)是-1表示不限库存，直接返回1
         */
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('exists', KEYS[1]) == 1) then");
        sb.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        sb.append("    local num = tonumber(ARGV[1]);");
        sb.append("    if (stock == -1) then");
        sb.append("        return -1;");
        sb.append("    end;");
        sb.append("    if (stock >= num) then");
        sb.append("        return redis.call('incrby', KEYS[1], 0 - num);");
        sb.append("    end;");
        sb.append("    return -2;");
        sb.append("end;");
        sb.append("return -3;");
        STOCK_LUA = sb.toString();

        StringBuilder sb1 = new StringBuilder();
        sb1.append("if (redis.call('exists', KEYS[1]) == 1) then");
        sb1.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        sb1.append("    local num = tonumber(ARGV[1]);");
        sb1.append("    if (stock >= num) then");
        sb1.append("        return redis.call('incrby', KEYS[1], 0 - num);");
        sb1.append("    end;");
        sb1.append("    return -2;");
        sb1.append("end;");
        sb1.append("return -3;");
        STOCK_LUA_1 = sb1.toString();

        StringBuilder sb2 = new StringBuilder();
        sb2.append("if (redis.call('exists', KEYS[1]) == 1) then");
        sb2.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        sb2.append("    local num = tonumber(ARGV[1]);");
        sb2.append("    if (stock >= 0) then");
        sb2.append("        return redis.call('incrby', KEYS[1], num);");
        sb2.append("    end;");
        sb2.append("    return -2;");
        sb2.append("end;");
        sb2.append("return -3;");
        STOCK_LUA_INCR = sb2.toString();
    }


    @Override
    public KillGoodsPriceDetailVO detail(int killId) {
        KillGoodsPriceDetailVO killGoodsPriceDetailVO = null;
        //1、先从缓存里面查询数据
        String killGoodsDetailId = "kill_good_detal:" + killId;

        //1、从本地缓存里面查询数据
        Cache killgoodsCache = cacheManager.getCache("killgoodDetail");
        Element element = killgoodsCache.get(killGoodsDetailId);
        if (null != element) {
            log.info(Thread.currentThread().getName() + "--------ehcache缓存里面得到数据-------");
            killGoodsPriceDetailVO = (KillGoodsPriceDetailVO) element.getObjectValue();
            return killGoodsPriceDetailVO;
        }

        //2、本地缓存里面没有从redis里面拿
        Object killGoodsPriceOb = redisTemplate.opsForValue().get(killGoodsDetailId);
        if (null != killGoodsPriceOb) {
            log.info(Thread.currentThread().getName() + "---redis缓存中得到的数据---------");
            return JSONObject.parseObject(killGoodsPriceOb.toString(), KillGoodsPriceDetailVO.class);
        }

        //程序要健壮一些
        synchronized (killGoodsPriceMapper) {
            //1、从本地缓存里面查询数据
            Element element2 = killgoodsCache.get(killGoodsDetailId);
            if (null != element2) {
                log.info(Thread.currentThread().getName() + "--------ehcache缓存里面得到数据-------");
                killGoodsPriceDetailVO = (KillGoodsPriceDetailVO) element2.getObjectValue();
                return killGoodsPriceDetailVO;
            }

            //1、从缓存里面拿
            killGoodsPriceOb = redisTemplate.opsForValue().get(killGoodsDetailId);
            if (null != killGoodsPriceOb) {
                log.info(Thread.currentThread().getName() + "---redis缓存中得到的数据---------");
                return JSONObject.parseObject(killGoodsPriceOb.toString(), KillGoodsPriceDetailVO.class);
            }
            //2、去数据库里面查询数据
            killGoodsPriceDetailVO = killGoodsPriceMapper.detail(killId);
            if (null != killGoodsPriceDetailVO) {
                killgoodsCache.putIfAbsent(new Element(killGoodsDetailId, killGoodsPriceDetailVO));
                redisTemplate.opsForValue().set(killGoodsDetailId, killGoodsPriceDetailVO, 2, TimeUnit.DAYS);
            } else {
                //防止缓存穿透  缓存时间一定要短 ，空数据没有必要占用redis内存
                redisTemplate.opsForValue().set(killGoodsDetailId, "null", 5, TimeUnit.MINUTES);
            }
        }
        return killGoodsPriceDetailVO;
    }

    @Override
    public Long stockByLua(String key, int num, String script) {
        // 脚本里的KEYS参数
        List<String> keys = new ArrayList<>();
        keys.add(key);
        // 脚本里的ARGV参数
        String arg1 = Integer.toString(num);
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(STOCK_LUA, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        return stringRedisTemplate.execute(redisScript, keys, arg1);
    }

    @Override
    public R killByDb(int killId, String userId) {
        KillGoodsPriceDetailVO killGoods = detail(killId);
        if (killGoods.getBegainTime().isAfter(LocalDateTime.now())) {
            return R.failed("抢购还未开始");
        }
        if (killGoods.getEndTime().isBefore(LocalDateTime.now())) {
            return R.failed("抢购已结束");
        }

        KillGoodsPrice killGoodsPrice = killGoodsPriceMapper.selectById(killId);
        if (killGoodsPrice == null) {
            log.info("秒杀商品不存在");
            return R.failed("秒杀商品不存在");
        }
        Integer orderCount = orderKillMapper.selectOrderCount(1, userId);
        if (orderCount > 0) {
            log.info("您已经秒杀过了");
            return R.failed("您已经秒杀过了");
        }
        KillGoodsPrice condition = new KillGoodsPrice();
        condition.setKillCount(1);
        condition.setId(killId);
        //数据库减库存
        int stock = killGoodsPriceMapper.updateStock(condition);
        //返回为0，库存不足
        if (stock == 0) {
            log.info("--------Insufficient stock------------");
            return R.failed("库存不足");
        }
        //秒杀成功，缓存秒杀用户和商品
        redisTemplate.opsForSet().add("killed_good_user:" + killId, userId);
        return R.ok(killGoods);
    }

    /**
     * 锁续命
     */
    private Timer continueLock(String lockKey) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                redisTemplate.expire(lockKey, 60, TimeUnit.SECONDS);
            }
        }, 0, 1);
        return timer;
    }

    @Override
    public R killByLua(int killId, String userId) {
        KillGoodsPriceDetailVO killGoods = detail(killId);
        if (killGoods.getBegainTime().isAfter(LocalDateTime.now())) {
            return R.failed("抢购还未开始");
        }
        if (killGoods.getEndTime().isBefore(LocalDateTime.now())) {
            return R.failed("抢购已结束");
        }

        //判断用户是否已经秒杀过
        Boolean member = redisTemplate.opsForSet().isMember("killed_good_user:" + killId, userId);
        /*if (member) {
            log.info("---------userId:" + userId + "----has secKilled");
            return R.failed("您已经秒杀过了");
        }*/
        String killGoodCountId = "kill_count:" + killId;
        //返回的数值,执行了lua脚本减库存
        Long stock = stockByLua(killGoodCountId, 1, STOCK_LUA);
        //库存没有初始化，秒杀场景一般不会出现这种问题，会提前进行缓存预热的。所以秒杀场景这里可以不写
        if (stock == -3L) {
            Timer timer = null;
            //new出来的，每个人都有一把
            RedisLock redisLock = new RedisLock(redisTemplate, REDIS_LOCK);
            try {
                //如果竞争锁成功  如果其他线程没竞争锁成功，这里是阻塞的
                if (redisLock.tryLock()) {
                    //锁续命
                    timer = continueLock(REDIS_LOCK);

                    stock = stockByLua(killGoodCountId, 1, STOCK_LUA);
                    if (stock == -3L) {
                        KillGoodsPrice killGoodsPrice = killGoodsPriceMapper.selectById(killId);
                        redisTemplate.opsForValue().set(killGoodCountId, killGoodsPrice.getKillCount(), 60 * 60, TimeUnit.SECONDS);
                        //再次去执行lua脚本，扣减库存
                        stock = stockByLua(killGoodCountId, 1, STOCK_LUA);
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                if (timer != null) {
                    timer.cancel();
                }
                //释放锁 。自己加的锁不能让别人释放，自己只能释放自己的锁
                //这里要进行一个value值的比较，只要自己的value值相等才能释放
                redisLock.unlock();
            }
        }
        //如果是这种情况，秒杀成功
        boolean flag = stock >= 0;
        if (!flag) {
            log.info("--------秒杀失败------------");
            return R.failed("秒杀失败");
        }
        redisTemplate.opsForSet().add("killed_good_user:" + killId, userId);
        return R.ok(killGoods);
    }

    @Override
    public R killByRedisLock(int killId, String userId) {
        return null;
    }

    @Override
    public R killByQueue(int killId, String userId) {
        killByQueueService.addQueue(new KiilBeanVO(killId, userId));
        return R.ok(null);
    }
}
