package com.lwn.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final String SING_KEY = "rightsTestManagement"; // 密钥
    private static final Long EXPIRATION = 43200000L; // 过期时间 EXPIRATION

    /**
     * 获取JWT字符串
     *
     * @param claims
     * @return
     */
    public static String getJWT(Map<String, Object> claims) {
        String compact = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SING_KEY) // 使用HS256算法
                .setClaims(claims) // 自定义payload
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // 设置过期时间
                .compact(); // 返回JWT字符串
        return compact;
    }

    /**
     * 解析JWT
     *
     * @param jwtStr
     * @return
     */
    public static Claims parseJWT(String jwtStr) {
        Claims body = Jwts.parser()
                .setSigningKey(SING_KEY) // 传入密钥
                .parseClaimsJws(jwtStr) // 传入JWT字符串
                .getBody(); // 获取Claims对象
        return body;
    }
}
