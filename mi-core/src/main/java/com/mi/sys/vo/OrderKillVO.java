package com.mi.sys.vo;

import com.mi.sys.entity.OrderKill;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderKillVO对象", description = "订单表VO对象")
public class OrderKillVO extends OrderKill {
    private static final long serialVersionUID = 1L;

    /**
     * 商品规格信息，这里有问题，一个订单有多个商品，这个不应该放这里
     */
    private KillGoodsPriceDetailVO killGoodsPriceDetail;
    /**
     * 收货地址Id
     */
    private Long addressId;
    /**
     * 秒杀订单包含的商品信息
     */
    private List<OrderGoodsKillVO> orderGoodsKillList;
}
