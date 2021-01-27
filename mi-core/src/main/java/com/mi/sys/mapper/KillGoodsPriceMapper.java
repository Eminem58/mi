package com.mi.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mi.sys.entity.KillGoodsPrice;
import com.mi.sys.vo.KillGoodsPriceDetailVO;

/**
 * <p>
 * 商品秒杀 Mapper 接口
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
public interface KillGoodsPriceMapper extends BaseMapper<KillGoodsPrice> {
    int updateStock(KillGoodsPrice record);
    KillGoodsPriceDetailVO detail(Integer id);
}
