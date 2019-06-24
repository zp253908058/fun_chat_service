package com.swpu.funchat.web.controller;

import com.alibaba.druid.util.StringUtils;
import com.swpu.funchat.config.FileStore;
import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.model.response.ResponseMessageEntity;
import com.swpu.funchat.web.service.UserService;
import com.swpu.funchat.web.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    private static Logger mLogger = LoggerFactory.getLogger(UserController.class);

    private UserService mUserService;

    @Autowired
    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    @PostMapping("/update/nickname")
    public ResponseMessageEntity updateNickname(@RequestParam long id, @RequestParam String nickname) {
        mUserService.updateNickname(id, nickname);
        return new ResponseMessageEntity("修改成功");
    }

    @PostMapping("/avatar")
    public ResponseMessageEntity updateAvatar(@RequestParam("id") long userId, @RequestParam("avatar") MultipartFile multipartFile) throws IOException {
        mLogger.info("upload start................................");
        mUserService.updateAvatar(userId, multipartFile);
        return new ResponseMessageEntity("修改成功");
    }
}
