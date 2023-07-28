package com.yaojunjie.demo.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-demo
 * @description:
 * @author: yjj
 * @create: 2022-06-13
 **/
@Data
public class Person {
    private List<Cat> catList;
    public Person(String name) {
        this.catList = new ArrayList<>();
        this.catList.add(new Cat(name));
        if ("a".equals(name)){
            this.catList.add(new Cat("a家的"));
            this.catList.add(new Cat("a家的"));
            this.catList.add(new Cat("a家的"));
        }
    }
}
