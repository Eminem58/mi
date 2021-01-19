package com.mi.sys.service.impl;

import com.mi.sys.entity.Order;
import com.mi.sys.mapper.OrderMapper;
import com.mi.sys.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
