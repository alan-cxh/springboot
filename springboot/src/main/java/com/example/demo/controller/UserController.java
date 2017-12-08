package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 2017/11/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserServiceImpl userService;

    /**
     * springboot 的基本使用方法，返回到template下的页面，String返回是静态页面文件名
     * @return
     */
    @RequestMapping("hello")
    public String hello() {
        System.out.println("你好，世界00---0");
        return "hello";
    }

    /**
     * 添加一条数据
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        for(int i= 0; i < 5; i ++){
            User user = new User();
            user.setUsername("alan chen");
            user.setPassword("123456");
            user.setCreateTime(new Date());
            userService.add(user);
        }
        return "hello";
    }


    /**
     * 获取一条数据，根据id查询
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public User get() {
        return userService.get((long) 1);
    }

    @RequestMapping("/getbyName")
    public String getbyName(){
        int i = 1/0;
//        return userService.getByName("alan chen");
        return "hellojsp";
    }

    @RequestMapping("cupPage")
    @ResponseBody
    public List<User> cutPage(){
        User user = new User();
        user.setPage(1);
        user.setSize(3);
        PageRequest pageRequest = new PageRequest(user.getPage()-1, user.getSize());

        return userService.cutPage(pageRequest);
    }
}
