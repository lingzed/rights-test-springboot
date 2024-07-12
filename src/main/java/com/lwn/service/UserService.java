package com.lwn.service;

import com.lwn.entity.LoginBean;
import com.lwn.entity.User;

public interface UserService {

    LoginBean handleLogin(User user) throws Exception;
}
