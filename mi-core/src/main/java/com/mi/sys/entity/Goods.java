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
 * 商品表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_goods")
@ApiModel(value="Goods对象", description="商品表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    @ApiModelProperty(value = "分类id")
    private Integer catId;

    @ApiModelProperty(value = "扩展分类id")
    private Integer extendCatId;

    @ApiModelProperty(value = "商品编号")
    private String goodsSn;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "点击数")
    private Integer clickCount;

    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "库存数量")
    private Integer storeCount;

    @ApiModelProperty(value = "商品评论数")
    private Integer commentCount;

    @ApiModelProperty(value = "商品重量克为单位")
    private Integer weight;

    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "本店价")
    private BigDecimal shopPrice;

    @ApiModelProperty(value = "商品成本价")
    private BigDecimal costPrice;

    @ApiModelProperty(value = "商品关键词")
    private String keywords;

    @ApiModelProperty(value = "商品简单描述")
    private String goodsRemark;

    @ApiModelProperty(value = "商品详细描述")
    private String goodsContent;

    @ApiModelProperty(value = "商品上传原始图")
    private String originalImg;

    @ApiModelProperty(value = "是否为实物")
    private Integer isReal;

    @ApiModelProperty(value = "是否上架")
    private Boolean isOnSale;

    @ApiModelProperty(value = "是否包邮0否1是")
    private Boolean isFreeShipping;

    @ApiModelProperty(value = "商品上架时间")
    private Integer onTime;

    @ApiModelProperty(value = "商品排序")
    private Integer sort;

    @ApiModelProperty(value = "是否推荐")
    private Boolean isRecommend;

    @ApiModelProperty(value = "是否新品")
    private Boolean isNew;

    @ApiModelProperty(value = "是否热卖")
    private Boolean isHot;

    @ApiModelProperty(value = "最后更新时间")
    private Integer lastUpdate;

    @ApiModelProperty(value = "商品所属类型id，取值表goods_type的cat_id")
    private Integer goodsType;

    @ApiModelProperty(value = "商品规格类型，取值表goods_type的cat_id")
    private Integer specType;

    @ApiModelProperty(value = "购买商品赠送积分")
    private Integer giveIntegral;

    @ApiModelProperty(value = "积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置")
    private Integer exchangeIntegral;

    @ApiModelProperty(value = "供货商ID")
    private Integer suppliersId;

    @ApiModelProperty(value = "商品销量")
    private Integer salesSum;

    @ApiModelProperty(value = "0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠")
    private Boolean promType;

    @ApiModelProperty(value = "优惠活动id")
    private Integer promId;

    @ApiModelProperty(value = "佣金用于分销分成")
    private BigDecimal commission;

    @ApiModelProperty(value = "SPU")
    private String spu;

    @ApiModelProperty(value = "SKU")
    private String sku;

    @ApiModelProperty(value = "配送物流shipping_area_id,以逗号分隔")
    private String shippingAreaIds;


}
