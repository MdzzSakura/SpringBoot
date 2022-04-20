package com.yaojunjie.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-demo
 * @description: 测试
 * @author: yjj
 * @create: 2022-04-20
 **/
@RestController
@RequestMapping("spring")
public class TestController {

    @RequestMapping("test")
    public String test() {
        System.out.println("我是test方法");
        return "123";
    }
}
