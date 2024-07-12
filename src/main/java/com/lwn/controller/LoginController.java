package com.lwn.controller;

import com.lwn.entity.LoginBean;
import com.lwn.entity.User;
import com.lwn.service.UserService;
import com.lwn.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/login")
@RestController
@Slf4j
public class LoginController {
    @Resource
    private UserService userService;
//    private

    @PostMapping
    public Result<LoginBean> login(@RequestBody User user) throws Exception {
        log.info("登录，user：{}", user);
        LoginBean loginBean = userService.handleLogin(user);
        return Result.success(loginBean);
    }
}
