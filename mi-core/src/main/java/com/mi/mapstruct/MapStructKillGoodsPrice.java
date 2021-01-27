package com.mi.mapstruct;

import com.mi.sys.entity.KillGoodsPrice;
import com.mi.sys.vo.KillGoodsPriceDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 传输对象之间互转工具类
 *
 * @author 金彪
 * @date 2021.01.27
 */
@Mapper
public interface MapStructKillGoodsPrice {
    MapStructKillGoodsPrice INSTANCE = Mappers.getMapper(MapStructKillGoodsPrice.class);

    KillGoodsPriceDetailVO entityToDetailVO(KillGoodsPrice killGoodsPrice);

    KillGoodsPrice detailVOToEntity(KillGoodsPriceDetailVO killGoodsPrice);
}
