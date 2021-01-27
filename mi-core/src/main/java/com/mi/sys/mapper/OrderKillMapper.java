package com.mi.sys.mapper;

import com.mi.sys.entity.OrderKill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
public interface OrderKillMapper extends BaseMapper<OrderKill> {
    /**
     * 根据类型和用户id查秒杀订单总数
     */
    Integer selectOrderCount(@Param("type") Integer type, @Param("userId") String userId);
}
