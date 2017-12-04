package com.example.demo.config;

import com.example.demo.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletRegistration;

/**
 *
 * Created by Alan on 2017/12/1.
 */
@Configuration

// 方法二：注册servlet配置，相当于包扫描，配置完注解完，就可不用配置以下信息，但是对于urlpath配置在每个servlet下@WebServlet(name = "TestServlet")
@ServletComponentScan   // 自动装配
public class ServletConfiguration  extends WebMvcConfigurerAdapter {

    /**
     * 方法一：注册servlet配置   // 手动装配
     *  生成servlet对象和路径
     * @return
     */
    /*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new TestServlet(), "/test");
    }*/
}
