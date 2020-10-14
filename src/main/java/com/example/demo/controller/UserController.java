package com.example.demo.controller;

import com.example.demo.bean.Json;
import com.example.demo.bean.User;
import com.example.demo.service.JsonService;
import com.example.demo.service.impl.UserService1;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class UserController {

    @Resource
    private UserService1 userService1;

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService1.getUserByName(name);
    }
    @RequestMapping("/getName/{id}")
    public User getUserByName(@PathVariable int id) {
        return userService1.getName(id);
    }


    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) throws Exception {
        if (null != user) {
            userService1.insert(user);
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/json")
    public Json getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (Json) application.getAttribute("json");
    }

    /**
     * 获取当前在线人数，
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    @Resource
    JsonService jsonService;
//    监听发布的时间
    @GetMapping("/publish")
    public String getRequestInfo1(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + jsonService.getUser2());
        return "success";
    }

}

