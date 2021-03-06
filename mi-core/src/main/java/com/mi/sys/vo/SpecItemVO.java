package com.mi.sys.vo;

import com.mi.sys.entity.SpecItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品规格项视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SpecItemVO对象", description = "商品规格项VO对象")
public class SpecItemVO extends SpecItem {
	private static final long serialVersionUID = 1L;

}
