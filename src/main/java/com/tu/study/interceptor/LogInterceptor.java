package com.tu.study.interceptor;

import com.tu.study.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 屠永建
 * @version 1.0
 * 2022/3/14 16:12
 **/
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Log methodAnnotation = handlerMethod.getMethodAnnotation(Log.class);
        return methodAnnotation!=null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Log methodAnnotation = handlerMethod.getMethodAnnotation(Log.class);
        if(methodAnnotation!=null){
            Method method = handlerMethod.getMethod();
            String annotationValue = methodAnnotation.value();
            String className = method.getDeclaringClass().getName();
            String methodName = method.getName();
            log.info("className:{},methodName:{},annotationValue:{}",className,methodName,annotationValue);
        }

    }
}
