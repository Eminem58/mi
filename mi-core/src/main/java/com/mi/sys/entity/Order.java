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
 * 订单表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_order")
@ApiModel(value="Order对象", description="订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "订单状态(0-待确认，1-已确认，2-已收货，3-已取消，4-已完成、5-已作废)")
    private Integer orderStatus;

    @ApiModelProperty(value = "发货状态（0-未发货、1-已发货、2-部分发货）")
    private Integer shippingStatus;

    @ApiModelProperty(value = "支付状态 （0-未支付，1-已支付）")
    private Integer payStatus;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    private String area;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    private String zipcode;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "物流code")
    private String shippingCode;

    @ApiModelProperty(value = "物流名称")
    private String shippingName;

    @ApiModelProperty(value = "支付code（alipay、weixin、cod）")
    private String payCode;

    @ApiModelProperty(value = "支付方式名称（支付宝支付、微信支付、货到付款）")
    private String payName;

    @ApiModelProperty(value = "发票抬头")
    private String invoiceTitle;

    @ApiModelProperty(value = "商品总价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "邮费")
    private BigDecimal shippingPrice;

    @ApiModelProperty(value = "使用余额")
    private BigDecimal userMoney;

    @ApiModelProperty(value = "优惠券抵扣")
    private BigDecimal couponPrice;

    @ApiModelProperty(value = "使用积分")
    private Integer integral;

    @ApiModelProperty(value = "使用积分抵多少钱")
    private BigDecimal integralMoney;

    @ApiModelProperty(value = "应付款金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "下单时间")
    private Long addTime;

    @ApiModelProperty(value = "最后新发货时间")
    private Long shippingTime;

    @ApiModelProperty(value = "订单确认时间（后台）")
    private Long confirmTime;

    @ApiModelProperty(value = "支付时间")
    private Long payTime;

    @ApiModelProperty(value = "活动id")
    private Integer orderPromId;

    @ApiModelProperty(value = "活动优惠金额")
    private BigDecimal orderPromAmount;

    @ApiModelProperty(value = "价格调整")
    private BigDecimal discount;

    @ApiModelProperty(value = "用户备注")
    private String userNote;

    @ApiModelProperty(value = "管理员备注")
    private String adminNote;

    @ApiModelProperty(value = "父单单号")
    private String parentSn;

    @ApiModelProperty(value = "是否已分成0未分成1已分成")
    private Boolean isDistribut;

    private Long receiveTime;


}
