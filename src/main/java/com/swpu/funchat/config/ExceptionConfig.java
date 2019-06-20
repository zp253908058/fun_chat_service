package com.swpu.funchat.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see ExceptionConfig
 * @since 2019-06-19
 */
@ControllerAdvice
public class ExceptionConfig {
    //1、浏览器客户端返回的都是json
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
