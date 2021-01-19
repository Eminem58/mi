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
 * 发货单
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_delivery_doc")
@ApiModel(value="DeliveryDoc对象", description="发货单")
public class DeliveryDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "发货单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "管理员ID")
    private String adminId;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "邮编")
    private String zipcode;

    @ApiModelProperty(value = "联系手机")
    private String mobile;

    @ApiModelProperty(value = "国ID")
    private Integer country;

    @ApiModelProperty(value = "省ID")
    private Integer province;

    @ApiModelProperty(value = "市ID")
    private Integer city;

    @ApiModelProperty(value = "区ID")
    private Integer district;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "物流code")
    private String shippingCode;

    @ApiModelProperty(value = "快递名称")
    private String shippingName;

    @ApiModelProperty(value = "运费")
    private BigDecimal shippingPrice;

    @ApiModelProperty(value = "物流单号")
    private String invoiceNo;

    @ApiModelProperty(value = "座机电话")
    private String tel;

    @ApiModelProperty(value = "管理员添加的备注信息")
    private String note;

    @ApiModelProperty(value = "友好收货时间")
    private Integer bestTime;

    @ApiModelProperty(value = "创建时间")
    private Integer createTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDel;


}
