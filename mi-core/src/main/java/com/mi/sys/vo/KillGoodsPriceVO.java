package com.mi.sys.vo;

import com.mi.sys.entity.KillGoodsPrice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品秒杀视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "KillGoodsPriceVO对象", description = "商品秒杀VO对象")
public class KillGoodsPriceVO extends KillGoodsPrice {
	private static final long serialVersionUID = 1L;

}
