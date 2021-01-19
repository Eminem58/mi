package com.mi.sys.vo;

import com.mi.sys.entity.GoodsHotsell;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsHotsellVO对象", description = "GoodsHotsellVO对象")
public class GoodsHotsellVO extends GoodsHotsell {
	private static final long serialVersionUID = 1L;

}
