package com.example.demo.controller;

import com.example.demo.bean.BusinessMsgEnum;
import com.example.demo.bean.JsonResult1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult1 test(@RequestParam("name") String name,
                            @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult1();
    }

    @GetMapping("/business")
    public JsonResult1 testException() {
        try {
            int i = 1 / 1;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult1();
    }
}

