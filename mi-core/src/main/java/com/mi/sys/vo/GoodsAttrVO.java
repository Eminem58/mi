package com.mi.sys.vo;

import com.mi.sys.entity.GoodsAttr;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品的属性视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsAttrVO对象", description = "商品的属性VO对象")
public class GoodsAttrVO extends GoodsAttr {
	private static final long serialVersionUID = 1L;

}
