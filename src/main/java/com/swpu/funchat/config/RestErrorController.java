package com.swpu.funchat.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see RestErrorController
 * @since 2019-06-19
 */
//@RestController
public class RestErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String error(HttpServletRequest request, HttpServletResponse response) {
        return "出错了。";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
