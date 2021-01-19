package com.mi.sys.vo;

import com.mi.sys.entity.SpecImage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品规格图片视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpecImageVO对象", description = "商品规格图片VO对象")
public class SpecImageVO extends SpecImage {
	private static final long serialVersionUID = 1L;

}
