package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.web.dao.RegisterDao;
import com.swpu.funchat.web.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see RegisterServiceImpl
 * @since 2019-06-16
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterDao mRegisterDao;

    @Autowired
    public void setRegisterDao(RegisterDao registerDao) {
        mRegisterDao = registerDao;
    }

    @Override
    public void phone(String phone, String password) {
        mRegisterDao.phone(phone, password);
    }
}
