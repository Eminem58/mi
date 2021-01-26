package com.mi.sys.service;

import com.mi.sys.vo.ShoppingGoodsVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/order/mall/service/IShoppingCartService")
public interface IShoppingCartService {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestParam("specGoodsId") Integer specGoodsId,
              @RequestParam("userId") String userId);

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    void remove(@RequestParam("specGoodsId") Integer specGoodsId, @RequestParam("userId") String userId);

    @RequestMapping(value = "/removeAll", method = RequestMethod.POST)
    void removeAll(@RequestParam("userId") String userId);

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    List<ShoppingGoodsVO> list(@RequestParam("userId") String userId);

    @RequestMapping(value = "/findBySpecGoodsId", method = RequestMethod.POST)
    ShoppingGoodsVO findBySpecGoodsId(@RequestParam("specGoodsId") Integer specGoodsId, @RequestParam("userId") String userId);

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    void updateStatus(@RequestParam("specGoodsIds") String specGoodsIds, @RequestParam("status") Integer status, @RequestParam("userId") String userId);

    @RequestMapping(value = "/findCheckedGoodsList", method = RequestMethod.POST)
    List<ShoppingGoodsVO> findCheckedGoodsList(@RequestParam("userId") String userId);

    @RequestMapping(value = "/removeCheckedGoodsList", method = RequestMethod.POST)
    void removeCheckedGoodsList(@RequestParam("userId") String userId);
}
