package com.example.demo.service;

import com.example.demo.bean.Json;
import com.example.demo.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JsonService {
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布事件
     * @return
     */
    public Json getUser2() {
        Json json = new Json(11, "CHELSEA");
        // 发布事件
        MyEvent event = new MyEvent(this, json);
        applicationContext.publishEvent(event);
        return json;
    }
}
