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
 * 订单操作日志表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_order_action")
@ApiModel(value="OrderAction对象", description="订单操作日志表")
public class OrderAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    @TableId(value = "action_id", type = IdType.AUTO)
    private Long actionId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "操作人 0 为管理员操作")
    private String actionUser;

    @ApiModelProperty(value = "交易类型")
    private String tradeType;

    @ApiModelProperty(value = "预支付交易会话标识")
    private String prepayId;

    @ApiModelProperty(value = "二维码链接")
    private String codeUrl;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "配送状态")
    private Integer shippingStatus;

    @ApiModelProperty(value = "支付状态")
    private Integer payStatus;

    @ApiModelProperty(value = "操作备注")
    private String actionNote;

    @ApiModelProperty(value = "操作时间")
    private Long logTime;

    @ApiModelProperty(value = "状态描述")
    private String statusDesc;


}
