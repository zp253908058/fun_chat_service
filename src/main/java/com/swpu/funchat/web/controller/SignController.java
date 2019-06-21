package com.swpu.funchat.web.controller;

import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.web.service.UserService;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see SignController
 * @since 2019-06-16
 */
@RestController
@RequestMapping("/sign/")
public class SignController {

    private UserService mUserService;

    @Autowired
    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    @PostMapping("phone")
    public UserInfo phone(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        return mUserService.login(phone, password);
    }

    @PostMapping("up")
    public String register(@RequestParam("phone") String phone, @RequestParam("password") String password) {

        return "注册成功";
    }
}
