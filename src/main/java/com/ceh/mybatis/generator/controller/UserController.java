package com.ceh.mybatis.generator.controller;

import com.ceh.mybatis.generator.domain.User;
import com.ceh.mybatis.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
