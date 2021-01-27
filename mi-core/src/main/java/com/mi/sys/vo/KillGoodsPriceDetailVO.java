package com.mi.sys.vo;

import com.mi.sys.entity.KillGoodsPrice;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀商品带规格VO对象
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "KillGoodsPriceDetailVo对象", description = "秒杀商品带规格VO对象")
public class KillGoodsPriceDetailVO extends KillGoodsPrice {
    private static final long serialVersionUID = 1L;

    private String goodsName;
    private String originalImg;
    private String key;
    private String keyName;
}
