package com.lwn.service.impl;

import com.lwn.common.LoginStatus;
import com.lwn.entity.LoginBean;
import com.lwn.entity.Rights;
import com.lwn.entity.User;
import com.lwn.mapper.UserMapper;
import com.lwn.service.RightsService;
import com.lwn.service.UserService;
import com.lwn.utils.JWTUtil;
import com.lwn.utils.TreeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RightsService rightsService;


    @Override
    public LoginBean handleLogin(User user) throws Exception {
        // 获取查询出的用户
        User u = userMapper.select(user);
        if (u == null) {
            throw new Exception(LoginStatus.ACCOUNT_ERROR);
        }
        // 通过user的roleId查询出对应的权限
        List<Rights> rightsList = rightsService.selectRightsByRole(u.getRoleId());
        // jwt中存入用户名
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username", u.getUsername());
        String jwt = JWTUtil.getJWT(claims);
        List<Rights> rights = TreeUtils.listToTree("0", rightsList);
        return LoginBean.getLoginBean(jwt, rights);
    }
}
