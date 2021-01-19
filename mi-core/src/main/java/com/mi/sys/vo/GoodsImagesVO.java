package com.mi.sys.vo;

import com.mi.sys.entity.GoodsImages;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品图片视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsImagesVO对象", description = "商品图片VO对象")
public class GoodsImagesVO extends GoodsImages {
	private static final long serialVersionUID = 1L;

}
