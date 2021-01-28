package com.mi.sys.service.impl;

import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mi.core.constant.OrderStatus;
import com.mi.core.constant.PayStatus;
import com.mi.core.constant.ShippingStatus;
import com.mi.core.utils.OrderNumGenerator;
import com.mi.mapstruct.MapStructOrderKill;
import com.mi.mongo.GoodsDao;
import com.mi.sys.entity.*;
import com.mi.sys.mapper.OrderActionKillMapper;
import com.mi.sys.mapper.OrderGoodsKillMapper;
import com.mi.sys.mapper.OrderKillMapper;
import com.mi.sys.mapper.UserAddressMapper;
import com.mi.sys.service.OrderKillService;
import com.mi.sys.vo.GoodsVO;
import com.mi.sys.vo.KillGoodsPriceDetailVO;
import com.mi.sys.vo.OrderKillVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 秒杀订单表 服务实现类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Service
public class OrderKillServiceImpl extends ServiceImpl<OrderKillMapper, OrderKill> implements OrderKillService {

    @Resource
    private OrderKillMapper orderKillMapper;
    @Resource
    private OrderGoodsKillMapper orderGoodsKillMapper;
    @Resource
    private OrderActionKillMapper orderActionKillKillMapper;
    @Resource
    private UserAddressMapper userAddressMapper;
    @Resource
    private OrderNumGenerator orderNumGenerator;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private DefaultUidGenerator defaultUidGenerator;

    @Override
    public Long submit(OrderKillVO orderKillVO) {
        KillGoodsPriceDetailVO killGoodsPriceDetail = orderKillVO.getKillGoodsPriceDetail();
        long now = System.currentTimeMillis();
        String userId = orderKillVO.getUserId();
        Long orderId = orderKillVO.getOrderId();
        //新增一个秒杀订单
        OrderKill orderKill1 = MapStructOrderKill.INSTANCE.vOToEntity(orderKillVO);
        orderKill1.setAddTime(now);
        orderKill1.setOrderSn(orderNumGenerator.nextId("K"));
        orderKill1.setOrderStatus(OrderStatus.UNCONFIRMED.getCode());
        orderKill1.setPayStatus(PayStatus.UNPAID.getCode());
        orderKill1.setShippingStatus(ShippingStatus.UNSHIPPED.getCode());
        UserAddress userAddress = userAddressMapper.selectById(orderKillVO.getAddressId());
        if (userAddress != null) {
            BeanUtils.copyProperties(userAddress, orderKill1);
        }
        orderKillMapper.insert(orderKill1);
        //从mongodb的购物车中获取所购物品，先简化从购物车获取一个商品
        List<OrderGoodsKill> orderGoodsKillList = new ArrayList<>();
        //GoodsVO goodsVO = goodsDao.findOneBySpecGoodsId(killGoodsPriceDetail.getSpecGoodsId());
        //先填个数据通过测试，findOneBySpecGoodsId方法还有点问题
        GoodsVO goodsVO = goodsDao.findOneById(1);
        OrderGoodsKill orderGoodsKill = new OrderGoodsKill();
        if (goodsVO != null) {
            BeanUtils.copyProperties(goodsVO, orderGoodsKill);
        }
        orderGoodsKill.setGoodsId(goodsVO.getGoodsId());
        orderGoodsKill.setOrderId(orderId);
        orderGoodsKill.setRecId(defaultUidGenerator.getUID());
        orderGoodsKill.setPromType(true);
        orderGoodsKill.setPromId(killGoodsPriceDetail.getId());
        orderGoodsKill.setGoodsNum(1);
        orderGoodsKill.setGoodsPrice(killGoodsPriceDetail.getPrice());
        orderGoodsKill.setSpecKey(killGoodsPriceDetail.getKey());
        orderGoodsKill.setSpecKeyName(killGoodsPriceDetail.getKeyName());
        orderGoodsKill.setSpecGoodsId(killGoodsPriceDetail.getSpecGoodsId());
        orderGoodsKill.setOriginalImg(killGoodsPriceDetail.getOriginalImg());
        orderGoodsKillList.add(orderGoodsKill);
        BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount.add(killGoodsPriceDetail.getPrice());
        orderKill1.setGoodsPrice(totalAmount);
        orderKill1.setShippingPrice(new BigDecimal(0));
        orderKill1.setOrderAmount(totalAmount.add(orderKill1.getShippingPrice()));
        orderKill1.setTotalAmount(totalAmount.add(orderKill1.getShippingPrice()));
        //修改订单表
        orderKillMapper.updateById(orderKill1);
        //新增秒杀订单的商品信息表
        orderGoodsKillMapper.insertBatch(orderGoodsKillList);
        //订单日志
        OrderActionKill orderActionKill = new OrderActionKill();
        orderActionKill.setActionId(defaultUidGenerator.getUID());
        orderActionKill.setActionUser(userId);
        orderActionKill.setLogTime(now);
        orderActionKill.setOrderId(orderId);
        orderActionKill.setOrderStatus(orderKillVO.getOrderStatus());
        orderActionKill.setPayStatus(orderKillVO.getPayStatus());
        orderActionKill.setShippingStatus(orderKillVO.getShippingStatus());
        orderActionKill.setStatusDesc("创建秒杀订单");
        orderActionKill.setActionNote(userId);
        orderActionKillKillMapper.insert(orderActionKill);
        return orderId;
    }

    @Override
    public void cancel(OrderKillVO orderKillVO) {
        orderKillVO.setOrderStatus(OrderStatus.CANCELED.getCode());
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("orderId", orderKillVO.getOrderId());
        List<OrderGoodsKill> orderGoodsKillList = orderGoodsKillMapper.selectByMap(map);
        for (OrderGoodsKill orderGoodsKill : orderGoodsKillList) {
            GoodsVO goodsVO = goodsDao.findOneById(orderGoodsKill.getGoodsId());
            if (goodsVO != null) {
                List<SpecGoodsPrice> specGoodsPriceList = goodsVO.getSpecGoodsPriceList();
                specGoodsPriceList.forEach(x -> x.setStoreCount(x.getStoreCount() + orderGoodsKill.getGoodsNum()));
                goodsVO.setSpecGoodsPriceList(specGoodsPriceList);
                goodsDao.save(goodsVO);
            }
        }
        orderKillMapper.updateById(orderKillVO);
        //订单日志
        OrderActionKill orderActionKill = new OrderActionKill();
        orderActionKill.setActionId(defaultUidGenerator.getUID());
        orderActionKill.setActionUser(orderKillVO.getUserId());
        orderActionKill.setLogTime(System.currentTimeMillis());
        orderActionKill.setOrderId(orderKillVO.getOrderId());
        orderActionKill.setOrderStatus(orderKillVO.getOrderStatus());
        orderActionKill.setPayStatus(orderKillVO.getPayStatus());
        orderActionKill.setShippingStatus(orderKillVO.getShippingStatus());
        orderActionKill.setStatusDesc("自动取消订单");
        orderActionKill.setActionNote(orderKillVO.getUserId());
        orderActionKillKillMapper.insert(orderActionKill);
    }

}
