package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.model.dto.UserAuth;
import com.swpu.funchat.model.dto.UserInfo;
import com.swpu.funchat.oauth.exception.EmptyPasswordException;
import com.swpu.funchat.oauth.exception.EmptyUsernameException;
import com.swpu.funchat.oauth.exception.UserNotFoundException;
import com.swpu.funchat.util.Check;
import com.swpu.funchat.web.dao.UserDao;
import com.swpu.funchat.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private UserDao mUserDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public UserInfo login(String username, String password) {
        Check.checkUsername(username);
        Check.checkPassword(password);
        UserAuth userAuth = mUserDao.getUserAuthByUsername(username);
        System.out.println(userAuth);
        if (userAuth == null) {
            throw new UserNotFoundException();
        }
        Check.checkPassword(password, userAuth.getCredential());
        UserInfo user = mUserDao.getUserInfoById(userAuth.getUserId());
        System.out.println(user);
        return user;
    }

    @Override
    public UserInfo getUserInfoById(long id) {
        return mUserDao.getUserInfoById(id);
    }
}
