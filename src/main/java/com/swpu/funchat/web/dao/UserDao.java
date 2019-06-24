package com.swpu.funchat.web.dao;

import com.swpu.funchat.model.dto.UserAuth;
import com.swpu.funchat.model.dto.UserId;
import com.swpu.funchat.model.dto.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserDao
 * @since 2019-06-15
 */
@Repository
@Mapper
public interface UserDao {

    UserInfo getUserInfoById(long userId);

    UserAuth getUserAuthByPhone(String phone);

    UserAuth getUserAuthByUserId(String userId);

    void updateLoginDate(long userId);

    void updateNickname(long userId, String nickname);

    UserId findId(long userId);

    void addUserId(long userId);

    void addUserAuth(@Param("item") UserAuth userAuth);

    void addUserInfoByUserId(long userId);

    void updateAvatar(long userId, String url);
}
