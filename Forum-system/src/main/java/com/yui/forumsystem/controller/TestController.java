package com.yui.forumsystem.controller;

import com.yui.forumsystem.common.AppResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// 指定测试根路径映射地址前缀

// Controller注解，返回的对象⽤JSON形式表⽰
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot...";
    }

    @GetMapping("/exception")
    public AppResult testException() throws  Exception {
        throw new Exception("This is a test exception");
    }

    @GetMapping("/appException")
    public AppResult testAppException() {
        throw new RuntimeException("This is a test runtime exception");
    }

}