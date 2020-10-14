package com.example.demo.dao;

import com.example.demo.bean.User;

import java.util.List;

public interface IUserDao  {
    List<User> findUserByName(String name);
    User findUserById(int id);
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);

}
