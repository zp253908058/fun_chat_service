package com.swpu.funchat.web.service.impl;

import com.swpu.funchat.model.dto.OauthClient;
import com.swpu.funchat.model.dto.UserAuth;
import com.swpu.funchat.web.dao.OauthDao;
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

    private OauthDao mOauthDao;

    @Autowired
    public OauthServiceImpl(OauthDao oauthDao) {
        mOauthDao = oauthDao;
    }

    @Override
    public List<OauthClient> getOauthClientByClientId(String clientId) {
        return mOauthDao.getOauthClientByClientId(clientId);
    }

    @Override
    public List<UserAuth> getOauthUserByUsername(String username) {
        return mOauthDao.getOauthUserByUsername(username);
    }
}
