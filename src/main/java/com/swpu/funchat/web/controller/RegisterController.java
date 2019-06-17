package com.swpu.funchat.web.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see RegisterController
 * @since 2019-06-16
 */
@RestController
@RequestMapping("/register/")
public class RegisterController {

    @PostMapping("phone")
    public String phone(@RequestParam String phone, @RequestParam String password) {
        return "注册成功。";
    }
}
