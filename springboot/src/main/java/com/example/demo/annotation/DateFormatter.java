package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 时间注解
 * Created by Alan on 2017/11/29.
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormatter {
    //  用于储存日期格式化样式
    String value() default "yyyy-MM-dd";
}
