package com.mi.sys.vo;

import com.mi.sys.entity.GoodsCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品分类视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsCategoryVO对象", description = "商品分类VO对象")
public class GoodsCategoryVO extends GoodsCategory {
	private static final long serialVersionUID = 1L;

}
