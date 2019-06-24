package com.swpu.funchat.web.service;

import com.swpu.funchat.model.dto.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserService
 * @since 2019-06-16
 */
public interface UserService {

    UserInfo login(String username, String password);

    void register(String phone, String password);

    void updateNickname(long id, String nickname);

    void updateAvatar(long userId, MultipartFile multipartFile) throws IOException;
}
