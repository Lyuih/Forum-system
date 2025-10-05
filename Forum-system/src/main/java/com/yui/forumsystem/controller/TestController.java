package com.yui.forumsystem.controller;

import com.yui.forumsystem.common.AppResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
// 指定测试根路径映射地址前缀

// Controller注解，返回的对象⽤JSON形式表⽰
@Api(tags = "测试类的相关接口")
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation("测试接口1，显示 Hello Spring Boot")
    @PostMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot...";
    }

    @ApiOperation("测试接口2，测试异常处理")
    @GetMapping("/exception")
    public AppResult testException() throws  Exception {
        throw new Exception("This is a test exception");
    }

    @ApiOperation("测试接口3，测试运行时异常处理")
    @GetMapping("/appException")
    public AppResult testAppException() {
        throw new RuntimeException("This is a test runtime exception");
    }

    @ApiOperation("测试接口4，传入姓名，返回 Hello + 姓名")
    @PostMapping("/helloByName")
    public String helloByName(@ApiParam(value = "姓名") @RequestParam("name") String name) {
        return "Hello, " + name;
    }


}