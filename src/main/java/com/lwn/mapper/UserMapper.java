package com.lwn.mapper;

import com.lwn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select username,password,role_id from user where username = #{username} " +
            "and password = #{password}")
    User select(User user);
}
