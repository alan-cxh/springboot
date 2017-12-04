package com.example.demo.controller;

import com.example.demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用于jsp页面的配置
 * Created by Alan on 2017/11/29.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private UserServiceImpl userService;
    /**
     * springboot 的基本使用方法，返回到template下的页面，String返回是静态页面文件名
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("你好，世界00---0");
        return "hellojsp";
    }


}
