package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.comment.UnInterception;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;


@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @UnInterception//自定义注释，不拦截
    @RequestMapping("/test1")
    public String test() {
        return "hello";
    }

    @Resource
    private IUserService userService;


}

