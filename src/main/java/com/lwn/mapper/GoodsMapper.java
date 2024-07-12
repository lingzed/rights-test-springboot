package com.lwn.mapper;

import com.lwn.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select * from goods")
    List<Goods> select();
}
