package com.mi.sys.vo;

import com.mi.sys.entity.GoodsType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品模型视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsTypeVO对象", description = "商品模型VO对象")
public class GoodsTypeVO extends GoodsType {
	private static final long serialVersionUID = 1L;

}
