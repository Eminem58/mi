package com.mi.sys.entity;

import java.math.BigDecimal;
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
 * 商品订单表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_order_goods_kill")
@ApiModel(value="OrderGoodsKill对象", description="商品订单表")
public class OrderGoodsKill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id自增")
    @TableId(value = "rec_id", type = IdType.AUTO)
    private Long recId;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    private Integer specGoodsId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "视频名称")
    private String goodsName;

    @ApiModelProperty(value = "商品货号")
    private String goodsSn;

    @ApiModelProperty(value = "购买数量")
    private Integer goodsNum;

    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "本店价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品成本价")
    private BigDecimal costPrice;

    @ApiModelProperty(value = "会员折扣价")
    private BigDecimal memberGoodsPrice;

    @ApiModelProperty(value = "购买商品赠送积分")
    private Integer giveIntegral;

    @ApiModelProperty(value = "商品规格key")
    private String specKey;

    @ApiModelProperty(value = "规格对应的中文名字")
    private String specKeyName;

    @ApiModelProperty(value = "条码")
    private String barCode;

    @ApiModelProperty(value = "是否评价")
    private Boolean isComment;

    @ApiModelProperty(value = "0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠")
    private Boolean promType;

    @ApiModelProperty(value = "活动id")
    private Integer promId;

    @ApiModelProperty(value = "0未发货，1已发货，2已换货，3已退货")
    private Boolean isSend;

    @ApiModelProperty(value = "发货单ID")
    private Integer deliveryId;

    @ApiModelProperty(value = "sku")
    private String sku;

    private String originalImg;


}
