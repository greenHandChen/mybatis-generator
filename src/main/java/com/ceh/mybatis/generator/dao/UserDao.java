package com.ceh.mybatis.generator.dao;

import com.ceh.mybatis.generator.domain.User;

/**
 * Created by enHui.Chen on 2018/9/18.
 */
public interface UserDao {
    User getUserById(Integer id);
}
