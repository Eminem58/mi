package com.mi.sys.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车添加VO对象
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "ShopppingGoodsAddVO对象", description = "购物车添加VO对象")
public class ShopppingGoodsAddVO {
    private static final long serialVersionUID = 1L;

    /**
     * 商品规格价格表id
     */
    private Integer specGoodsId;
    /**
     * 数量
     */
    private Integer num;
}
