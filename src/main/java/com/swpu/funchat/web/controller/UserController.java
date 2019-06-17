package com.swpu.funchat.web.controller;

import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.oauth.UserWrapper;
import com.swpu.funchat.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserController
 * @since 2019-06-16
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService mUserService;

    @Autowired
    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    @PostMapping("register")
    public void registerByPhone(String phone, String password) {

    }

    @GetMapping
    public UserInfo getUser(Principal principal) {
        UserWrapper userWrapper = (UserWrapper) principal;
        return mUserService.getUserInfoById(userWrapper.getUserAuth().getUserId());
    }
}
