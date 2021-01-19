package com.mi.sys.vo;

import com.mi.sys.entity.SpecGoodsPrice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品规则价格视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpecGoodsPriceVO对象", description = "商品规则价格VO对象")
public class SpecGoodsPriceVO extends SpecGoodsPrice {
	private static final long serialVersionUID = 1L;

}
