package com.mi.sys.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.mi.sys.service.IShoppingCartService;
import com.mi.sys.vo.ShopppingGoodsAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 购物车相关
 */
@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartContoller extends ApiController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    /**
     * 添加到购物车
     *
     * @param shopppingGoodsAddVO
     * @return
     */
    @PostMapping("/add")
    public R add(@RequestBody ShopppingGoodsAddVO shopppingGoodsAddVO) {
        shoppingCartService.save(shopppingGoodsAddVO.getSpecGoodsId(), "zs");
        return R.ok("ok");
    }

    /**
     * 查询购物车内容
     *
     * @return
     */
    @GetMapping("/list")
    public R list() {
        return R.restResult(shoppingCartService.list("zs"), ApiErrorCode.SUCCESS);
    }
}
