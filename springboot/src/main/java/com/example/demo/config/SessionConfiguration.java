package com.example.demo.config;

import com.example.demo.interceptor.LoggerInterceptor;
import com.example.demo.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 登录拦截器在springboot中的配置信息，注册到springboot中
 * Created by Alan on 2017/11/30.
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 拦截器注册
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**"); // 登录拦截器
//        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");  // 日志记录
    }

    /**
     * 静态资源注册
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态文件地址设置。
        registry.addResourceHandler("springboot/resource/**").addResourceLocations("classpath:/static/");
    }
}
