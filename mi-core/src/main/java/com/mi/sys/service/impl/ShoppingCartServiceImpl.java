package com.mi.sys.service.impl;

import com.mi.core.exception.BusinessException;
import com.mi.mongo.GoodsDao;
import com.mi.mongo.ShoppingCartDao;
import com.mi.sys.entity.SpecGoodsPrice;
import com.mi.sys.service.IShoppingCartService;
import com.mi.sys.vo.GoodsVO;
import com.mi.sys.vo.ShoppingGoodsVO;
import com.mi.sys.vo.UserShoppingGoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 金彪
 * @date 2021-01-20
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    @Resource
    private ShoppingCartDao shoppingCartDao;
    @Resource
    private GoodsDao goodsDao;


    @Override
    public void save(Integer specGoodsId, String userId) {
        /*UserShoppingGoodsVO userShoppingGoods = shoppingCartDao.findByUserId(userId);
        if (userShoppingGoods == null) {
            userShoppingGoods = new UserShoppingGoodsVO();
        }
        userShoppingGoods.setUserId(userId);
        GoodsVO goodsVo = goodsDao.findOneBySpecGoodsId(specGoodsId);
        if (goodsVo == null) {
            throw new BusinessException("没有找到对应的商品");
        }
        if (goodsVo.getIsOnSale() == false) {
            throw new BusinessException("对不起，该商品已下架");
        }
        List<SpecGoodsPrice> machedSpecGoodsPriceList = goodsVo.getSpecGoodsPriceList().stream().filter(specGoodsPrice -> specGoodsPrice.getId().intValue() == specGoodsId.intValue()).collect(Collectors.toList());
        if (machedSpecGoodsPriceList == null || machedSpecGoodsPriceList.size() == 0) {
            throw new BusinessException("没有找到对应的商品");
        }

        BigDecimal price = machedSpecGoodsPriceList.get(0).getPrice();
        String keyName = machedSpecGoodsPriceList.get(0).getKeyName();

        //取出购物车的商品集合
        List<ShoppingGoodsVO> shoppingGoodsList = userShoppingGoods.getShoppingGoodsList();
        if (shoppingGoodsList == null) {
            shoppingGoodsList = new ArrayList<>();
        }
        //购物车中没有该类型商品，则直接添加
        if (CollectionUtils.isEmpty(shoppingGoodsList)
                || shoppingGoodsList.stream().filter(shoppingGoodsVo -> shoppingGoodsVo.getSpecGoodsId().intValue() == specGoodsId.intValue()).count() == 0) {
            ShoppingGoodsVO shoppingGoodsVo = new ShoppingGoodsVO();
            shoppingGoodsVo.setSpecGoodsId(specGoodsId);
            shoppingGoodsVo.setGoodsId(goodsVo.getGoodsId());
            shoppingGoodsVo.setGoodsName(goodsVo.getGoodsName());
            shoppingGoodsVo.setOriginalImg(goodsVo.getOriginalImg());
            shoppingGoodsVo.setPrice(price);
            shoppingGoodsVo.setNum(1);
            shoppingGoodsVo.setStatus(1);
            shoppingGoodsVo.setKeyName(keyName);
            shoppingGoodsList.add(shoppingGoodsVo);
            userShoppingGoods.setShoppingGoodsList(shoppingGoodsList);
        } else { //购物车中有该类型商品，则根据保存模式决定累加还是替换
            for (ShoppingGoodsVO vo : shoppingGoodsList) {
                if (vo.getSpecGoodsId().intValue() == specGoodsId.intValue()) {
                    vo.setGoodsId(goodsVo.getGoodsId());
                    vo.setGoodsName(goodsVo.getGoodsName());
                    vo.setOriginalImg(goodsVo.getOriginalImg());
                    vo.setPrice(price);
                    vo.setNum(vo.getNum() + 1);
                    break;
                }
            }
            userShoppingGoods.setShoppingGoodsList(shoppingGoodsList);
        }*/
        UserShoppingGoodsVO userShoppingGoods = new UserShoppingGoodsVO();
        List<ShoppingGoodsVO> shoppingGoodsList = new ArrayList<>();
        ShoppingGoodsVO shoppingGoodsVo = new ShoppingGoodsVO();
        userShoppingGoods.setUserId(userId);
        shoppingGoodsVo.setSpecGoodsId(specGoodsId);
        shoppingGoodsVo.setGoodsId(1);
        shoppingGoodsVo.setGoodsName("Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机");
        shoppingGoodsVo.setOriginalImg("/picture/M00/00/00/rB4ABl8MJi6AXFgUAADEzPQRaLg285.jpg");
        shoppingGoodsVo.setPrice(new BigDecimal(100));
        shoppingGoodsVo.setNum(1);
        shoppingGoodsVo.setStatus(1);
        shoppingGoodsVo.setKeyName("iPhone");
        shoppingGoodsList.add(shoppingGoodsVo);
        userShoppingGoods.setShoppingGoodsList(shoppingGoodsList);
        shoppingCartDao.save(userShoppingGoods);
    }

    @Override
    public void remove(Integer specGoodsId, String userId) {

    }

    @Override
    public void removeAll(String userId) {

    }

    @Override
    public List<ShoppingGoodsVO> list(String userId) {
        UserShoppingGoodsVO vo = shoppingCartDao.findByUserId(userId);
        if (vo != null) {
            return vo.getShoppingGoodsList();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ShoppingGoodsVO findBySpecGoodsId(Integer specGoodsId, String userId) {
        return null;
    }

    @Override
    public void updateStatus(String specGoodsIds, Integer status, String userId) {

    }

    @Override
    public List<ShoppingGoodsVO> findCheckedGoodsList(String userId) {
        return null;
    }

    @Override
    public void removeCheckedGoodsList(String userId) {

    }
}
