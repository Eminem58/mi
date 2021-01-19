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
 * 商品分类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_goods_category")
@ApiModel(value="GoodsCategory对象", description="商品分类")
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "手机端显示的商品分类名")
    private String mobileName;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "家族图谱")
    private String parentIdPath;

    @ApiModelProperty(value = "等级")
    private Boolean level;

    @ApiModelProperty(value = "顺序排序")
    private Integer sortOrder;

    @ApiModelProperty(value = "是否显示")
    private Boolean isShow;

    @ApiModelProperty(value = "分类图片")
    private String image;

    @ApiModelProperty(value = "是否推荐为热门分类")
    private Boolean isHot;

    @ApiModelProperty(value = "分类分组默认0")
    private Boolean catGroup;

    @ApiModelProperty(value = "分佣比例")
    private Boolean commissionRate;


}
