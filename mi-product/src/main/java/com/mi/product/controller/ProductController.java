package com.mi.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author 金彪
 * @date 2021-01-19
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/test")
    public ArrayList test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("zs");
        return arrayList;
    }
}
