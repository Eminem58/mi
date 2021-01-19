package com.mi.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品的属性
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_goods_attr")
@ApiModel(value="GoodsAttr对象", description="商品的属性")
public class GoodsAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品属性id自增")
    @TableId(value = "goods_attr_id", type = IdType.AUTO)
    private Integer goodsAttrId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "属性id")
    private Integer attrId;

    @ApiModelProperty(value = "属性值")
    private String attrValue;

    @ApiModelProperty(value = "属性价格")
    private String attrPrice;


}
