package com.mi.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mi.sys.entity.OrderKill;
import com.mi.sys.vo.OrderKillVO;

/**
 * <p>
 * 秒杀订单表 服务类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
public interface OrderKillService extends IService<OrderKill> {
    /**
     * 提交秒杀订单
     *
     * @author 金彪
     * @date 2021.01.28
     */
    Long submit(OrderKillVO orderKillVO);
    /**
     * 提交秒杀订单
     *
     * @author 金彪
     * @date 2021.01.28
     */
    void cancel(OrderKillVO orderKillVO);
}
