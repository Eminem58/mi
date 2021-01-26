package com.mi.sys.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户购物车VO对象
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "UserShoppingGoodsVO对象", description = "用户购物车VO对象")
public class UserShoppingGoodsVO {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userId;
    private List<ShoppingGoodsVO> shoppingGoodsList;
}
