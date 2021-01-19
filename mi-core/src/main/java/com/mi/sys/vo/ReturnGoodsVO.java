package com.mi.sys.vo;

import com.mi.sys.entity.ReturnGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品提货表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ReturnGoodsVO对象", description = "商品提货表VO对象")
public class ReturnGoodsVO extends ReturnGoods {
	private static final long serialVersionUID = 1L;

}
