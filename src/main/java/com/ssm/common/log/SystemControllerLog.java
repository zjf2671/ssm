package com.ssm.common.log;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解 拦截Controller 
 * @author harry.zhang
 * @CreateDate:	2017年12月11日
 * @version 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String description() default "";
}