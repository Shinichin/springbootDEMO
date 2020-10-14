package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

public interface IUserService {
    List<User> findUserByName(String name);
    User findUserById(int id);
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
