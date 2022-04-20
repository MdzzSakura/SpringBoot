package com.yaojunjie.demo.common.aspect;

/**
 * @program: springboot-demo
 * @description: 第一个切面
 * @author: yjj
 * @create: 2022-04-20
 **/
public class OrderOneAspect {

    public void oneBefore() {
        System.out.println("我是oneBefore");
    }

    public void oneAfter() {
        System.out.println("我是oneAfter");
    }
}
