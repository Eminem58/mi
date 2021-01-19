package com.mi.sys.vo;

import com.mi.sys.entity.Shipping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShippingVO对象", description = "ShippingVO对象")
public class ShippingVO extends Shipping {
	private static final long serialVersionUID = 1L;

}
