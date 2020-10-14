package com.example.demo.dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//基于注解的整合
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id= #{id}")
    User getName(@Param("id") int id);

    @Select("insert into user(id,name,sex,age) values (#{id},#{name},#{sex},#{age})")
    Integer insertUser(User user);
}
