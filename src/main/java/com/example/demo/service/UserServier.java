package com.example.demo.service;

import com.example.demo.bean.Json;
import com.example.demo.bean.User;

import java.sql.SQLException;

public interface UserServier {
    User getUserByName(String name);
    User getName(int name);
    void insert(User user) throws SQLException;
}
