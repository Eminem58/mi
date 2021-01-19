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
 * 商品规格项
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_spec_item")
@ApiModel(value="SpecItem对象", description="商品规格项")
public class SpecItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格项id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "规格id")
    private Integer specId;

    @ApiModelProperty(value = "规格项")
    private String item;


}
