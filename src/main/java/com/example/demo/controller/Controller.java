package com.example.demo.controller;

import com.example.demo.bean.Json;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.stereotype.Controller//默认返回siew对象，要加 @ResponseBody
@RequestMapping("/test")
public class Controller {
    @Resource
    private IUserService userService;
    @ResponseBody
    @RequestMapping("/{id}")
    public String init(@PathVariable(value="id") int id){
        return userService.findUserById(id).getName();
    }

    @RequestMapping("/query")
    public String show(Model model){
        model.addAttribute("info",userService.findUserById(1));
        return "UserInfo";
    }
    //通过名字查询
    @ResponseBody
    @GetMapping("/findUserByName")
    public List<User> findUserByName(@RequestParam("name") String name){
        List<User> list=userService.findUserByName(name);
        return list;
    }
    //通过ID查询
    @ResponseBody
    @GetMapping("/findUserById")
    public User findUserById(@RequestParam("id") int id){
        User user=userService.findUserById(id);
        return user;
    }
    @ResponseBody
    @PostMapping("/findUserBy")
    public User findUserBy(@RequestParam("id") int id){
        System.out.println("ooooooo"+id);
        User user=userService.findUserById(id);
        return user;
    }
    //通过ID删除
    @ResponseBody
    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam(value = "id",required = false) int id){
        userService.deleteUser(id);
    }
    //修改
    @ResponseBody
    @PostMapping("/updateUser")
    public void updateUser( User  user){
        System.out.println("------------------------"+user);
        userService.updateUser(user);
    }
    //添加
    @ResponseBody
    @PostMapping("/insertUser")
    public void insertUser(User user){
        System.out.println(user.getName());
        userService.insertUser(user);
    }
    @RequestMapping("/seach")//跳到搜索页面的映射
    public String seach(){
        return "SearchName";
    }
    @RequestMapping("/seachUser")
    public String getName(User user,Model model){
        List<User> list=userService.findUserByName(user.getName());
       System.out.println(list.size()+" "+user.getName());
        model.addAttribute("USER",list);
        return "SearchName";
    }
    @ResponseBody
    @PostMapping("/123")
    public void updateUser1( User user){
        System.out.println("------------------------"+user.getSex());

    }
}
