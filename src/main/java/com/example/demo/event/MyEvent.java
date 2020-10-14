package com.example.demo.event;

import com.example.demo.bean.Json;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * 定义一个 User 对象来模拟数据，构造方法中将 Json 对象传进来初始化
 */
public class MyEvent extends ApplicationEvent {

    private Json json;

    public MyEvent(Object source, Json json) {
        super(source);
        this.json = json;
    }

    public Json getJson() {
        return json;
    }

    public void setJson(Json json) {
        this.json = json;
    }
}

