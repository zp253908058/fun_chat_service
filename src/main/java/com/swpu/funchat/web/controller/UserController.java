package com.swpu.funchat.web.controller;

import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserController
 * @since 2019-06-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService mUserService;

    @Autowired
    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    @GetMapping
    public UserInfo getUser(@RequestParam long id) {
//        UserWrapper userWrapper = (UserWrapper) principal;
        return mUserService.getUserInfoById(id);
    }

    @GetMapping("/{userId}/username")
    public String getUsername(@PathVariable("userId") long userId) {
        return mUserService.getUserInfoById(userId).getNickname();
    }
}
