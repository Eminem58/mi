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
 * 商品提货表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_return_goods")
@ApiModel(value="ReturnGoods对象", description="商品提货表")
public class ReturnGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "退货申请表id自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "0退货1换货")
    private Boolean type;

    @ApiModelProperty(value = "退换货原因")
    private String reason;

    @ApiModelProperty(value = "拍照图片路径")
    private String imgs;

    @ApiModelProperty(value = "申请时间")
    private Integer addtime;

    @ApiModelProperty(value = "0申请中1客服理中2已完成")
    private Boolean status;

    @ApiModelProperty(value = "客服备注")
    private String remark;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品规格key 对应tp_spec_goods_price 表")
    private String specKey;


}
