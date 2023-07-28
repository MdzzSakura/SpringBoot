package com.yaojunjie.demo.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import jdk.nashorn.internal.ir.CatchNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: springboot-demo
 * @description: 测试
 * @author: yjj
 * @create: 2022-06-13
 **/
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("a"));
        list.add(new Person("b"));
        list.add(new Person("c"));

        //个数
        Map<String, List<Cat>> collect = list.stream()
                .map(Person::getCatList)
                .map(listStream -> listStream.stream().map(beanStream -> beanStream))
                .flatMap(listStream -> listStream)
                .collect(Collectors.groupingBy(Cat::getName));

        System.out.println(JSONUtil.toJsonStr(collect));
    }
}
