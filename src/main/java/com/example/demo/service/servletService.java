package com.example.demo.service;

import com.example.demo.bean.Json;
import org.springframework.stereotype.Service;

@Service("servletService")
public class servletService {
    public Json getJson() {
        return new Json(99,"监听者");
    }
}
