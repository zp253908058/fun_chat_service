package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.web.dao.AuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
public class UserDetailsServiceImpl {

    private AuthDao mAuthDao;

    @Autowired
    public void setAuthDao(AuthDao authDao) {
        mAuthDao = authDao;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserAuth auth = mAuthDao.getAuthByUsername(s);
//        if (auth == null) {
//            throw new UserNotFoundException();
//        }
//        return new UserWrapper(auth);
//    }
}
