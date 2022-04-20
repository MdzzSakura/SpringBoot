package com.yaojunjie.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: springboot-demo
 * @description: 第二个切面
 * @author: yjj
 * @create: 2022-04-20
 **/
public class OrderTwoAspect {
    public Object twoAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("我是twoAround");
        Object process = pjp.proceed();
        System.out.println("环绕后");
        return process;
    }
}
