package com.mi.sys.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 购物车VO对象
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "ShoppingGoodsVO对象", description = "购物车VO对象")
public class ShoppingGoodsVO {
    private static final long serialVersionUID = 1L;

    /**
     * 商品规格价格表id
     */
    private Integer specGoodsId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     *
     */
    private String originalImg;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 状态，0：未选中，1：选中
     */
    private Integer status;
    /**
     *
     */
    private String keyName;
}
