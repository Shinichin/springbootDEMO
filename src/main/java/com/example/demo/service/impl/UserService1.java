package com.example.demo.service.impl;

import com.example.demo.bean.Json;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserServier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.sql.SQLException;

@Service("userService1")
public class UserService1 implements UserServier {
    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;
    @Override
    public User getName(int id) {
        return userMapper.getName(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(User user) throws SQLException {
        try{
            userMapper.insertUser(user);
//       throw new RuntimeException();//手动抛出异常
            throw new SQLException("数据库异常");
        } catch(Exception e) {

        }
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

}
