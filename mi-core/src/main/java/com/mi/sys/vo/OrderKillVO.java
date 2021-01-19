package com.mi.sys.vo;

import com.mi.sys.entity.OrderKill;
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
@ApiModel(value = "OrderKillVO对象", description = "订单表VO对象")
public class OrderKillVO extends OrderKill {
	private static final long serialVersionUID = 1L;

}
