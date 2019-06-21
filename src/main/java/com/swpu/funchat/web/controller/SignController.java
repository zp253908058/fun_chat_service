package com.swpu.funchat.web.controller;

import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.model.response.ResponseMessageEntity;
import com.swpu.funchat.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see SignController
 * @since 2019-06-16
 */
@RestController
@RequestMapping(value = "/sign/", produces = "application/json;charset=UTF-8")
public class SignController {
    public static Logger mLogger = LoggerFactory.getLogger(SignController.class);

    private UserService mUserService;

    @Autowired
    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    @PostMapping("phone")
    public UserInfo phone(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        mLogger.info("phone = " + phone + ", password = " + password);
        return mUserService.login(phone, password);
    }

    @PostMapping("up")
    public ResponseMessageEntity register(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        mLogger.info("phone = " + phone + ", password = " + password);
        return new ResponseMessageEntity("注册成功");
    }
}
