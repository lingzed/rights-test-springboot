package com.lwn.controller;

import com.lwn.entity.UserInfo;
import com.lwn.service.UserInfoService;
import com.lwn.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping
    public Result<List<UserInfo>> queryUserInfo() {
        List<UserInfo> userInfos = userInfoService.queryUserInfo();
        return Result.success(userInfos);
    }
}
