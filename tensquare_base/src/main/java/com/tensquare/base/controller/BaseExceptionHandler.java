package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@Controller
public class BaseExceptionHandler<ControllerAdvice> {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false,StatusCode.ERROR, e.getMessage());
    }
}