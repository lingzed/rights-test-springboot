package com.lwn.controller;

import com.lwn.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valid_token")
public class ValidJWTController {

    /**
     * 在请求发送到该方法之前，会经过拦截器校验jwt是否合法，若经过该请求响应则jwt合法
     * 若经过拦截器响应，则jwt不合法
     * @return
     */
    @GetMapping
    public Result validJWT() {
        return Result.success();
    }
}
