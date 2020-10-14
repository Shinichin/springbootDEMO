package com.example.demo.servlet;

import com.example.demo.bean.Json;
import com.example.demo.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器，监听MyEvent事件
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        Json json = myEvent.getJson();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        System.out.println("id：" + json.getId());
        System.out.println("用户名：" + json.getName());

    }
}

