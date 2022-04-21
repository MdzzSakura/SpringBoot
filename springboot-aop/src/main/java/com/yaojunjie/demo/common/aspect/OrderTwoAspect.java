package com.yaojunjie.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: springboot-demo
 * @description: 第二个切面
 * @author: yjj
 * @create: 2022-04-20
 **/
public class OrderTwoAspect {

    public void twoBefore() {
        System.out.println("我是twoBefore");
    }

    public void twoAfter() {
        System.out.println("我是twoAfter");
    }

    public Object twoAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("twoAround环绕前");
        Object process = pjp.proceed();
        System.out.println("twoAround环绕后");
        return process;
    }

    public void twoAfterReturning() throws Throwable {
        System.out.println("我是twoAfterReturning");
    }
}
