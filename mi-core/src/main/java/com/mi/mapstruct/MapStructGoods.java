package com.mi.mapstruct;

import com.mi.sys.entity.Goods;
import com.mi.sys.vo.GoodsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 传输对象之间互转工具类
 *
 * @author 金彪
 * @date 2021.01.27
 */
@Mapper
public interface MapStructGoods {
    MapStructGoods INSTANCE = Mappers.getMapper(MapStructGoods.class);

    GoodsVO entityToVO(Goods goods);

    Goods vOToEntity(GoodsVO goodsVO);
}
