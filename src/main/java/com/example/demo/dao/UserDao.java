package com.example.demo.dao;

import com.example.demo.bean.User;

public interface UserDao {
    User getUserByName(String name);
}
