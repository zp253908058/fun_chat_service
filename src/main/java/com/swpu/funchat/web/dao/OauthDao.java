package com.swpu.funchat.web.dao;

import com.swpu.funchat.model.dto.OauthClient;
import com.swpu.funchat.model.dto.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
@Repository
@Mapper
public interface OauthDao {

    List<OauthClient> getOauthClientByClientId(String clientId);

    List<UserAuth> getOauthUserByUsername(String username);

}
