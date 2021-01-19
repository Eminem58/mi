package com.mi.sys.vo;

import com.mi.sys.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderVO对象", description = "订单表VO对象")
public class OrderVO extends Order {
	private static final long serialVersionUID = 1L;

}
