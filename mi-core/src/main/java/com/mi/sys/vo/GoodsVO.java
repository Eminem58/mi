package com.mi.sys.vo;

import com.mi.sys.entity.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsVO对象", description = "商品表VO对象")
public class GoodsVO extends Goods {
	private static final long serialVersionUID = 1L;

}
