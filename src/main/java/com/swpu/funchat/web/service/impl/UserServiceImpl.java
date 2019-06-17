package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.model.dto.UserInfo;
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
    public UserInfo getUserInfoById(long id) {
        return mUserDao.getUserInfoById(id);
    }
}
