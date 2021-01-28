package com.mi.mq;

import com.alibaba.fastjson.JSON;
import com.mi.config.RabbitConfig;
import com.mi.mapstruct.MapStructOrderGoodsKill;
import com.mi.mapstruct.MapStructOrderKill;
import com.mi.sys.entity.OrderGoodsKill;
import com.mi.sys.entity.OrderKill;
import com.mi.sys.mapper.OrderGoodsKillMapper;
import com.mi.sys.service.IKillService;
import com.mi.sys.service.OrderKillService;
import com.mi.sys.vo.OrderKillVO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author 金彪
 * @date 2021-01-28
 */
@Component
@Slf4j
public class KillReceiver {
    @Resource
    private OrderKillService orderKillService;
    @Resource
    private OrderGoodsKillMapper orderGoodsKillMapper;
    @Resource
    private KillSender killSender;
    @Resource
    private IKillService killService;
    /**
     * 加库存lua脚本
     */
    private static final String STOCK_LUA_INCR;

    static {
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

    @RabbitListener(queues = RabbitConfig.QUEUE_KILL)
    @RabbitHandler//此注解加上之后可以接受对象型消息
    public void process(Message message, Channel channel) throws IOException {
        try {
            String string = new String(message.getBody());
            System.out.println("======receiveMsg======：" + string);
            OrderKillVO orderKillVO = JSON.parseObject(string, OrderKillVO.class);
            //生成订单
            orderKillService.submit(orderKillVO);
            //同时放到延迟队列
            killSender.sendToDelayQueue(orderKillVO);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            //不要重新入队了
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, false);
            //throw e;
        }
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_KILL_DEAD)
    @RabbitHandler
    public void processDead(Message message, Channel channel) throws IOException {
        try {
            String msg = new String(message.getBody());
            System.out.println("======receiveDeadMsg======：" + msg);
            OrderKillVO vo = JSON.parseObject(msg, OrderKillVO.class);
            Long orderId = vo.getOrderId();
            OrderKill orderKill = orderKillService.getById(orderId);
            if (orderKill != null) {
                //1、校验订单是否已经支付，查询该订单的支付状态
                OrderKillVO orderKillVO = MapStructOrderKill.INSTANCE.entityToVO(orderKill);
                HashMap<String, Object> map = new HashMap<>(2);
                map.put("orderId", orderId);
                List<OrderGoodsKill> orderGoodsKillList = orderGoodsKillMapper.selectByMap(map);
                orderKillVO.setOrderGoodsKillList(MapStructOrderGoodsKill.INSTANCE.entitysToVOs(orderGoodsKillList));
                //2、如果未支付就把订单取消，修改订单状态
                if (orderKillVO.getPayStatus() != null && "0".equals(orderKillVO.getPayStatus().toString())) {
                    orderKillService.cancel(orderKillVO);
                    //3、把库存+1操作，暂时只改一个
                    String killGoodCount = "kill_count:" + orderKillVO.getOrderGoodsKillList().get(0).getSpecGoodsId();
                    //返回的数值,执行了lua脚本
                    Long stock = killService.stockByLua(killGoodCount, 1, STOCK_LUA_INCR);
                    if (stock > 0) {
                        log.info("---------增加库存成功---stock:" + stock);
                    }
                }
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            //不要重新入队了
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, false);
            //throw e;
        }
    }
}
