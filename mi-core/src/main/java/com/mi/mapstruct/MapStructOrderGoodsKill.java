package com.mi.mapstruct;

import com.mi.sys.entity.OrderGoodsKill;
import com.mi.sys.vo.OrderGoodsKillVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * 传输对象之间互转工具类
 *
 * @author 金彪
 * @date 2021.01.27
 */
@Mapper
public interface MapStructOrderGoodsKill {
    MapStructOrderGoodsKill INSTANCE = Mappers.getMapper(MapStructOrderGoodsKill.class);

    OrderGoodsKillVO entityToVO(OrderGoodsKill orderGoodsKill);

    OrderGoodsKill vOToEntity(OrderGoodsKillVO orderGoodsKillVO);

    List<OrderGoodsKillVO> entitysToVOs(List<OrderGoodsKill> orderGoodsKillList);

    List<OrderGoodsKill> vOsToEntitys(List<OrderGoodsKillVO> orderGoodsKillVOList);
}
