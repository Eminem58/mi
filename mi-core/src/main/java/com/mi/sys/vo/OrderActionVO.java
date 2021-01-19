package com.mi.sys.vo;

import com.mi.sys.entity.OrderAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 订单操作日志表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderActionVO对象", description = "订单操作日志表VO对象")
public class OrderActionVO extends OrderAction {
	private static final long serialVersionUID = 1L;

}
