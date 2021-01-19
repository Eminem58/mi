package com.mi.sys.vo;

import com.mi.sys.entity.Brand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 品牌表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BrandVO对象", description = "品牌表VO对象")
public class BrandVO extends Brand {
	private static final long serialVersionUID = 1L;

}
