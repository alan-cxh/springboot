package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常捕捉处理类
 * Created by Alan on 2017/11/30.
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus
    public String defaultExceptionHandler(Exception e) {
        return "全局异常捕捉  " + e.getMessage();
    }
}

