package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.model.dto.OauthClient;
import com.swpu.funchat.model.dto.UserAuth;
import com.swpu.funchat.web.dao.AuthDao;
import com.swpu.funchat.web.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
@Service
public class OauthServiceImpl implements OauthService {

    private AuthDao mAuthDao;

    @Autowired
    public OauthServiceImpl(AuthDao authDao) {
        mAuthDao = authDao;
    }

    @Override
    public List<OauthClient> getOauthClientByClientId(String clientId) {
        return mAuthDao.getOauthClientByClientId(clientId);
    }

    @Override
    public List<UserAuth> getOauthUserByUsername(String username) {
        return mAuthDao.getOauthUserByUsername(username);
    }
}
