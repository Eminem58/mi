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
 * 品牌表
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_brand")
@ApiModel(value="Brand对象", description="品牌表")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌表")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌logo")
    private String logo;

    @ApiModelProperty(value = "品牌描述")
    private String desc;

    @ApiModelProperty(value = "品牌地址")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "品牌分类")
    private String catName;

    @ApiModelProperty(value = "分类id")
    private Integer parentCatId;

    @ApiModelProperty(value = "分类id")
    private Integer catId;

    @ApiModelProperty(value = "是否推荐")
    private Boolean isHot;


}
