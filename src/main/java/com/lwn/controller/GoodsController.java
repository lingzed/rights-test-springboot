package com.lwn.controller;

import com.lwn.entity.Goods;
import com.lwn.service.GoodsService;
import com.lwn.service.UserInfoService;
import com.lwn.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping
    public Result<List<Goods>> findGoods() {
        List<Goods> goods = goodsService.queryGoods();
        return Result.success(goods);
    }

    @PutMapping
    public Result editGoods() {
//        List<Goods> goods = goodsService.queryGoods();
        return Result.success();
    }
}
