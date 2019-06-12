package com.swpu.funchat.web.service;

import com.swpu.funchat.model.dto.OauthClient;
import com.swpu.funchat.model.dto.UserAuth;

import java.util.List;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
public interface OauthService {

    List<OauthClient> getOauthClientByClientId(String clientId);

    List<UserAuth> getOauthUserByUsername(String username);
}
