package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 登录拦截器
 * Created by Alan on 2017/11/30.
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println(request.getRequestURI());
//        路径不存在时,如果不存在，则跳转/404路径，如果处于未登录状态，则跳转到“/”路径， 否则以处于登录，等进入/404路径下的404.html页面
        if (request.getRequestURI().equals("/error")){
            System.out.println("不存在当前访问路径");
            response.sendRedirect("/404");
            return true;
        }
//        首次登录项目
        if (request.getRequestURI().equals("/") || request.getRequestURI().equals("/login")) {
            return true;
        }

//        当session中没有当前用户信息时
        Object object = request.getSession().getAttribute("session_user");
        if (object != null) {
            System.out.println("您好，当前您处于登录状态"+ new Date());
            return true;
        }
        response.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
