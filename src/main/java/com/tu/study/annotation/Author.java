package com.tu.study.annotation;

import java.lang.annotation.*;

/**
 * @author tuyongjian
 * @date 2022/8/24 14:46
 * 认证注解
 */


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Author {

    boolean mustLogin() default false;
}
