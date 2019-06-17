package com.swpu.funchat.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see RegisterDao
 * @since 2019-06-16
 */
@Mapper
@Repository
public interface RegisterDao {

    void phone(String phone, String password);
}
