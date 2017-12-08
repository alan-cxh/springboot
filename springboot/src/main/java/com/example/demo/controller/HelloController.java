package com.example.demo.controller;

import com.example.demo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用于jsp页面的配置
 * Created by Alan on 2017/11/29.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private final static Logger log = LoggerFactory.getLogger(HelloController.class);


    @Resource
    private UserServiceImpl userService;

    /*日志*/
    @RequestMapping("/testLog")
    @ResponseBody
    public String testLog() {
        log.debug("debug log");
        log.info("info log");
        log.error("error log");
        return "hellojsp";
    }


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
