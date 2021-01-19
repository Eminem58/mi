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
@TableName("tp_goods_attribute")
@ApiModel(value="GoodsAttribute对象", description="")
public class GoodsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性id")
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Integer attrId;

    @ApiModelProperty(value = "属性名称")
    private String attrName;

    @ApiModelProperty(value = "属性分类id")
    private Integer typeId;

    @ApiModelProperty(value = "0不需要检索 1关键字检索 2范围检索")
    private Boolean attrIndex;

    @ApiModelProperty(value = "0唯一属性 1单选属性 2复选属性")
    private Boolean attrType;

    @ApiModelProperty(value = " 0 手工录入 1从列表中选择 2多行文本框")
    private Boolean attrInputType;

    @ApiModelProperty(value = "可选值列表")
    private String attrValues;

    @ApiModelProperty(value = "属性排序")
    private Integer order;


}
