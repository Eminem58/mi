package com.mi.sys.vo;

import com.mi.sys.entity.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 地区表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RegionVO对象", description = "地区表VO对象")
public class RegionVO extends Region {
	private static final long serialVersionUID = 1L;

}
