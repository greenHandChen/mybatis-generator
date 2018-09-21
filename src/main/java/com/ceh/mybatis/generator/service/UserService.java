package com.ceh.mybatis.generator.service;

import com.ceh.mybatis.generator.dao.UserDao;
import com.ceh.mybatis.generator.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enHui.Chen on 2018/9/18.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
