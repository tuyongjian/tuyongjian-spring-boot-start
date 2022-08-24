package com.tu.study.interceptor;

import com.tu.study.annotation.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 屠永建
 * @version 1.0
 * 2022/3/14 16:12
 **/
@Slf4j
public class AuthorInterceptor implements HandlerInterceptor {

    private static final String USER_TOKEN="Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Author methodAnnotation = handlerMethod.getMethodAnnotation(Author.class);
        //不等于空，判断是否强制登录
        if(methodAnnotation!=null && methodAnnotation.mustLogin()){
            //获取用户的token
            return request.getAttribute(USER_TOKEN) != null && !StringUtils.isEmpty(request.getAttribute(USER_TOKEN));
            //校验token是否合法
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }
}
