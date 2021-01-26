package com.mi.sys.vo;

import com.mi.sys.entity.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "GoodsVO对象", description = "商品表VO对象")
public class GoodsVO extends Goods {
    private static final long serialVersionUID = 1L;
    /**
     * 商品相册
     */
    private List<GoodsImages> imageList;
    /**
     * 商品属性
     */
    private List<GoodsAttr> attrsList;
    /**
     * 规格价格
     */
    private List<SpecGoodsPrice> specGoodsPriceList;
    /**
     * 商品已选的规格列表
     */
    private List<Spec> goodsSpecList;
    /**
     * category parent_id_path,分类的ID路径，便于按分类搜索商品
     */
    private String catIdPath;
    private Integer defaultSpecId;
}
