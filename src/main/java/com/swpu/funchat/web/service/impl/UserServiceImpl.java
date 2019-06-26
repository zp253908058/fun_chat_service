package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.config.ApplicationConfig;
import com.swpu.funchat.config.FileStore;
import com.swpu.funchat.exception.EmptyFileException;
import com.swpu.funchat.exception.InnerServiceException;
import com.swpu.funchat.model.dto.UserAuth;
import com.swpu.funchat.model.dto.UserId;
import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.oauth.exception.UserNotFoundException;
import com.swpu.funchat.util.Check;
import com.swpu.funchat.util.IdGenerator;
import com.swpu.funchat.util.Validator;
import com.swpu.funchat.web.dao.UserDao;
import com.swpu.funchat.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.UUID;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserServiceImpl
 * @since 2019-06-16
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger mLogger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao mUserDao;
    private Environment environment;

    @Autowired
    public void setUserDao(UserDao userDao) {
        mUserDao = userDao;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public UserInfo login(String username, String password) {
        Check.checkUsername(username);
        Check.checkPassword(password);
        UserAuth userAuth;
        if (Validator.isMobileNumber(username)) {
            userAuth = mUserDao.getUserAuthByPhone(username);
        } else {
            userAuth = mUserDao.getUserAuthByUserId(username);
        }
        if (userAuth == null) {
            throw new UserNotFoundException();
        }
        Check.checkPassword(password, userAuth.getCredential());
        mUserDao.updateLoginDate(userAuth.getUserId());
        UserInfo user = mUserDao.getUserInfoById(userAuth.getUserId());
        System.out.println(user);
        return user;

        //TODO 验证账号是否可用
    }

    @Override
    @Transactional
    public void register(String phone, String password) {
        Check.checkPhone(phone);
        Check.checkPassword(password);
        long userId;
        for (; ; ) {
            userId = IdGenerator.generateId();
            UserId id = mUserDao.findId(userId);
            if (id == null) {
                break;
            }
        }
        mUserDao.addUserId(userId);
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(userId);
        userAuth.setIdentityType(1);
        userAuth.setIdentifier(phone);
        userAuth.setCredential(password);
        mUserDao.addUserAuth(userAuth);
        mUserDao.addUserInfoByUserId(userId);
        //TODO 验证账号是否可用
    }

    @Override
    public void updateNickname(long id, String nickname) {
        mUserDao.updateNickname(id, nickname);
    }

    @Override
    public String updateAvatar(long userId, MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            throw new EmptyFileException();
        }
        String fileName = UUID.randomUUID().toString(); // 新文件名
        File dest = new File(FileStore.AVATAR_DIR + fileName);
        File parent = dest.getParentFile();
        if (!parent.exists()) {
            boolean success = parent.mkdirs();
            if (!success) {
                throw new InnerServiceException();
            }
        }
        multipartFile.transferTo(dest);
        URL url = new URL("http", ApplicationConfig.IP, getPort(), "/funchat/avatar/" + fileName);
        String res = url.toString();
        mUserDao.updateAvatar(userId, res);
        return res;
    }


    private int getPort() {
        String port = environment.getProperty("local.server.port");
        if (port == null || port.isEmpty()) {
            return 80;
        }
        return Integer.parseInt(port);
    }
}
