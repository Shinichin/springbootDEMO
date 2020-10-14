package com.example.demo.controller;

import com.example.demo.bean.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.Json;
import com.example.demo.bean.JsonResult;

import javax.annotation.Resource;

@RestController
@RequestMapping("/json")
public class testController {
    private final static Logger logger = LoggerFactory.getLogger(testController.class);

    @Resource
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("getJson")
    public JsonResult<Json> getJson(){
        Json json= new Json(1,null);
        return new JsonResult<>(json);
    }
    @RequestMapping("/log")
    public String testLog(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======chelsea的个人博客：{}；chelsea的CSDN博客：{}", str1, str2);

        return "success";
    }
    @RequestMapping("/config")
    public String testConfig() {
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());

        return "success";
    }
}
