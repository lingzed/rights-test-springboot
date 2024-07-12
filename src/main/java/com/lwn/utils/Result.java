package com.lwn.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    // 状态码
    private Integer code;
    // 提示信息
    private String msg;
    // 响应的数据
    private T data;

    // 静态方法，快速生成成功的响应
    public static <T> Result<T> success(T data) {
        return new Result<>(1, "success", data);
    }

    // 静态方法，success的重载，快速生成成功无数据的响应
    public static Result success() {
        return new Result(1, "success", null);
    }

    // 静态方法，快速生成失败的响应
    public static Result<String> error(String msg) {
        return new Result<>(0, msg, null);
    }
}
