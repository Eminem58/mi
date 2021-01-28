package com.mi.mapstruct;

import com.mi.sys.entity.OrderKill;
import com.mi.sys.vo.OrderKillVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 传输对象之间互转工具类
 *
 * @author 金彪
 * @date 2021.01.27
 */
@Mapper
public interface MapStructOrderKill {
    MapStructOrderKill INSTANCE = Mappers.getMapper(MapStructOrderKill.class);

    OrderKillVO entityToVO(OrderKill orderKill);

    OrderKill vOToEntity(OrderKillVO orderKillVO);
}
