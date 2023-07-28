package com.yaojunjie.demo.common;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description:
 * @author: yjj
 * @create: 2022-06-13
 **/
@Data
public class Cat {
    private String name;
    private String eat;

    public Cat(String name){
        this.name = name;
    }
}
