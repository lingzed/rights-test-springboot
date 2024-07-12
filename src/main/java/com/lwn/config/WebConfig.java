package com.lwn.config;

import com.lwn.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;


    @Override // 重写addInterceptors方法
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        registry.addInterceptor(loginCheckInterceptor)往环境中注册该拦截器
        addPathPatterns，指定该拦截器拦截哪些请求
         */
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/validJWT");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .maxAge(3600)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION")
                .allowedOrigins("http://localhost:5555/")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
