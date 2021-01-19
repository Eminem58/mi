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
 * 
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_shipping")
@ApiModel(value="Shipping对象", description="")
public class Shipping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表 id")
    @TableId(value = "shipping_id", type = IdType.AUTO)
    private Integer shippingId;

    @ApiModelProperty(value = "快递代号")
    private String shippingCode;

    @ApiModelProperty(value = "快递名称")
    private String shippingName;

    @ApiModelProperty(value = "描述")
    private String shippingDesc;

    @ApiModelProperty(value = "保险")
    private String insure;

    @ApiModelProperty(value = "是否开启")
    private Boolean enabled;


}
