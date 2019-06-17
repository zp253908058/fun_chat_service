package com.swpu.funchat.web.dao;

import com.swpu.funchat.model.dto.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    UserInfo getUserInfoById(long id);
}
