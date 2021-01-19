package com.mi.sys.vo;

import com.mi.sys.entity.Spec;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品规格表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpecVO对象", description = "商品规格表VO对象")
public class SpecVO extends Spec {
	private static final long serialVersionUID = 1L;

}
