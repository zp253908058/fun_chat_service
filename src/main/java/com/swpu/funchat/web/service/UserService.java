package com.swpu.funchat.web.service;

import com.swpu.funchat.model.dto.UserInfo;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserService
 * @since 2019-06-16
 */
public interface UserService {

    UserInfo getUserInfoById(long id);
}
