package com.itheima.controller;

import com.itheima.controller.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R dootherException(Exception ex){
        ex.printStackTrace();
        return new R("系统错误，请稍后重试");
    }
}
