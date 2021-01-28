package com.mi.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mi.sys.entity.OrderGoodsKill;

import java.util.List;

/**
 * <p>
 * 商品订单表 Mapper 接口
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
public interface OrderGoodsKillMapper extends BaseMapper<OrderGoodsKill> {
    int insertBatch(List<OrderGoodsKill> list);
}
