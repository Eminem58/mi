package com.mi.sys.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.mi.sys.service.IKillService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 秒杀模块
 */
@RestController
@RequestMapping("/api/kill")
public class KillContoller extends ApiController {
    @Autowired
    private IKillService killService;

    @PostMapping("/killByDb")
    public R killByDb(int killId) {
        return killService.killByDb(killId, "zs");
    }

    @PostMapping("/killByLua")
    public R killByLua(int killId) {
        return killService.killByLua(killId, "zs");
    }

    @PostMapping("/killByQueue")
    public R killByQueue(int killId) {
        return killService.killByQueue(killId, "zs");
    }

    @PostMapping("/submitOrder")
    public R submitOrder(Long addressId, @Validated @Length(max = 2, message = "最大{max}") int killId) {
        return killService.submitOrder(addressId, killId, "zs");
    }

}
