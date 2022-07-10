package com.yjj.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-demo
 * @description: 第一个切面
 * @author: yjj
 * @create: 2022-04-20
 **/
//@Aspect
//@Component
public class OrderOneAspect {

    @Pointcut("execution(* com.yaojunjie..controller.*Controller.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void oneBefore() {
        System.out.println("我是oneBefore");
    }

    @AfterReturning(value = "pointCut()")
    public void oneAfterReturning() throws Throwable {
        System.out.println("我是oneAfterReturning");
    }

    @After(value = "pointCut()")
    public void oneAfter() {
        System.out.println("我是oneAfter");
    }

    @Around(value = "pointCut()")
    public Object oneAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("oneAround环绕前");
        Object process = pjp.proceed();
        System.out.println("oneAround环绕后");
        return process;
    }


}
