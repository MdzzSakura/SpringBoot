package com.yjj.demo.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String processSQL(String sql, Map<String, String> replacements) {
        // Find the position of "WHERE" (case insensitive)
        int whereIndex = sql.toUpperCase().indexOf("WHERE");

        if (whereIndex == -1) {
            // No WHERE clause found
            return sql;
        }

        // Extract the part after WHERE
        String whereClause = sql.substring(whereIndex + "WHERE".length());

        // Define the regex pattern to match {*}
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(whereClause);

        // Replace all occurrences of the pattern
        StringBuffer processedWhereClause = new StringBuffer();
        while (matcher.find()) {
            String key = matcher.group(1); // Get the key inside {*}
            String replacement = replacements.getOrDefault(key, ""); // Get the value from the map
            matcher.appendReplacement(processedWhereClause, "'" + replacement + "'"); // Add single quotes
        }
        matcher.appendTail(processedWhereClause);

        // Reconstruct the SQL statement
        String processedSQL = sql.substring(0, whereIndex + "WHERE".length()) + processedWhereClause.toString();

        return processedSQL;
    }

    public static void main(String[] args) {
        // Example usage
        String sql = "SELECT * FROM table_name WHERE column1 = key1 AND column2 = key2 or column3 = key3";
        Map<String, String> replacements = MapUtil.builder(new HashMap<String, String>())
                .put("key2", "value").build();

        String processedSQL = processSQL(sql, replacements);
        System.out.println(processedSQL);
    }




}
