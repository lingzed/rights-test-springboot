package com.lwn.service.impl;

import com.lwn.entity.UserInfo;
import com.lwn.mapper.UserInfoMapper;
import com.lwn.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryUserInfo() {
        return userInfoMapper.select();
    }
}
