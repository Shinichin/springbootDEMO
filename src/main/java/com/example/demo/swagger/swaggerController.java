package com.example.demo.swagger;

import com.example.demo.bean.Info;
import com.example.demo.bean.JsonResult;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2 在线接口文档")
public class swaggerController {
    @Resource
    private IUserService userService;

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") int id) {
        // 模拟数据库中根据id获取User信息
        User i=userService.findUserById(id);
        return new JsonResult(i);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public JsonResult<Void> insertUser(@RequestBody @ApiParam(value = "用户信息") User user) {
        // 处理添加逻辑
        userService.insertUser(user);
        return new JsonResult<>();
    }

}
