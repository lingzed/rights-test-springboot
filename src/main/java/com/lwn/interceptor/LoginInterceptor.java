package com.lwn.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lwn.common.LoginStatus;
import com.lwn.common.Message;
import com.lwn.utils.JWTUtil;
import com.lwn.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Interceptor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override // 目标资源(控制器)方法执行之前执行，返回true，目标资源方法执行，返回false，拦截，目标资源方法不执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行 OPTIONS 请求
        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
            log.info("OPTIONS请求放行");
            return true;
        }

        // 定义错误的返回，并转换为Json字符串
        String error = JSONObject.toJSONString(Result.error(LoginStatus.NOT_LOGIN));

        // 获取JWT
        String jwt = request.getHeader("token");
        log.info("jwt:{}", jwt);

        // 如果JWT不存在，不放行
        if (!StringUtils.hasLength(jwt)) {
            log.info("jwt不存在");
            response.getWriter().write(error);
            return false;
        }

        // 校验JWT，如果失效不放行
        try {
            JWTUtil.parseJWT(jwt);
            log.info("jwt有效");
        } catch (Exception e) {
            log.info("jwt无效");
            response.getWriter().write(error);
            return false;
        }

        return true;
    }

    @Override // 控制器方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle 运行了");
    }

    @Override // 视图渲染完成之后执行，最后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion 运行了");
    }
}
