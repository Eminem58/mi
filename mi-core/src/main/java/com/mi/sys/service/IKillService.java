package com.mi.sys.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.mi.sys.vo.KillGoodsPriceDetailVO;

/**
 * 秒杀服务扣减库存
 */
public interface IKillService {

    /**
     * 查询秒杀商品信息
     *
     * @author 金彪
     * @date 2021.01.26
     */
    KillGoodsPriceDetailVO detail(int killId);
    /**
     * lua脚本预扣库存
     *
     * @author 金彪
     * @date 2021.01.26
     */
    Long stockByLua(String key, int num, String script);
    /**
     * 基于数据库行锁做扣减库存完成秒杀
     *
     * @author 金彪
     * @date 2021.01.26
     */
    R killByDb(int killId, String userId);
    /**
     * 基于lua脚本做扣减库存完成秒杀
     *
     * @author 金彪
     * @date 2021.01.26
     */
    R killByLua(int killId, String userId);

    R killByRedisLock(int killId, String userId);

    R killByQueue(int killId, String userId);

}
