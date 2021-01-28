package com.mi.sys.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.mi.mongo.GoodsDao;
import com.mi.sys.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/sys/goods")
public class GoodsController extends ApiController {
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 添加商品
     *
     * @param goodsVO
     * @return
     */
    @PostMapping("/add")
    public R add(@RequestBody GoodsVO goodsVO) {
        goodsDao.save(goodsVO);
        return R.ok("ok");
    }
}

