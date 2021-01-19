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
 * 商品图片
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_goods_images")
@ApiModel(value="GoodsImages对象", description="商品图片")
public class GoodsImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片id 自增")
    @TableId(value = "img_id", type = IdType.AUTO)
    private Integer imgId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "图片地址")
    private String imageUrl;


}
