package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 用户登录类
 * Created by Alan on 2017/11/30.
 */
@Controller
public class LoginController {

    /**
     * 用户登录界面
     * @return
     */
    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        request.getSession().setAttribute("session_user", "alan chen");
        user.setCreateTime(new Date());
        System.out.println(user);
        return "index";
    }

    /**
     * 用户退出系统
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "logout";
    }
}
