package com.tu.study.autoconfig;

import com.tu.study.interceptor.AuthorInterceptor;
import com.tu.study.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 屠永建
 * @version 1.0
 * 2022/3/14 16:14
 **/
@Configuration
public class AutoConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new AuthorInterceptor());
    }
}
