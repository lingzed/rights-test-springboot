package com.lwn.service.impl;

import com.lwn.entity.Goods;
import com.lwn.mapper.GoodsMapper;
import com.lwn.service.GoodsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsMapperImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoods() {
        return goodsMapper.select();
    }
}
