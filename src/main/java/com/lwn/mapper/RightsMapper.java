package com.lwn.mapper;

import com.lwn.entity.Rights;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RightsMapper {
    @Select("select * from rights where parent_id is null")
    List<Rights> select();

    @Select("select * from rights where parent_id is not null")
    List<Rights> select1();


    @Select("select * from rights")
    List<Rights> select2();

//    @Select("select * from rights")
    List<Rights> selectByRole(Integer roleId);
}
