package com.example.demo.controller;

import com.example.demo.bean.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class thyController {
    @RequestMapping("/test404")
    public String test404() {
        return "testThy";
    }

    @RequestMapping(value="/index", method= RequestMethod.GET)
//加了@ResponseBody 就是返回字符串了
    public String index(ModelMap map) {
//返回值给页面
        map.addAttribute("name", "chelsea-李");
        return "index";
    }
    @GetMapping("/getBlogger")
    public String getBlogger(Model model) {
        Blogger blogger = new Blogger(1L, "倪升武", "123456");
        model.addAttribute("blogger", blogger);
        return "blogger";
    }
    @GetMapping("/getList")
    public String getList(Model model) {
        Blogger blogger1 = new Blogger(1L, "倪升武", "123456");
        Blogger blogger2 = new Blogger(2L, "达人课", "123456");
        List<Blogger> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }

}
