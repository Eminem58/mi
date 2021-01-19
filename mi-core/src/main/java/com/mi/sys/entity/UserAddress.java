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
 * 用户地址表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_user_address")
@ApiModel(value="UserAddress对象", description="用户地址表")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    private String zipcode;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "默认收货地址")
    private Boolean isDefault;

    private Boolean isPickup;

    @ApiModelProperty(value = "地址标签")
    private String label;


}
