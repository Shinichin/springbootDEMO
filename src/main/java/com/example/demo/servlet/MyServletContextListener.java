package com.example.demo.servlet;

import com.example.demo.bean.Json;
import com.example.demo.service.UserServier;
import com.example.demo.service.servletService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 使用ApplicationListener来初始化一些数据到application域中的监听器
 * @author shengni ni
 * @date 2018/07/05
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的service
        servletService servletService = applicationContext.getBean(servletService.class);
        Json json = servletService.getJson();
        // 获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("json", json);
    }
}

