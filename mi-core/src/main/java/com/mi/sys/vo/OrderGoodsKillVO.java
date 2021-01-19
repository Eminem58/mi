package com.mi.sys.vo;

import com.mi.sys.entity.OrderGoodsKill;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品订单表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderGoodsKillVO对象", description = "商品订单表VO对象")
public class OrderGoodsKillVO extends OrderGoodsKill {
	private static final long serialVersionUID = 1L;

}
