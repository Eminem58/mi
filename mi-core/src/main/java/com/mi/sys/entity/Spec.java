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
 * 商品规格表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_spec")
@ApiModel(value="Spec对象", description="商品规格表")
public class Spec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格表")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "规格类型")
    private Integer typeId;

    @ApiModelProperty(value = "规格名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer order;

    @ApiModelProperty(value = "是否需要检索：1是，0否")
    private Boolean searchIndex;


}
