package com.lightmall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/json")
    public Object json() {
        return new String[]{"message", "Hello, JSON!"};
    }

    @GetMapping("/db")
    public String testDb() {
        try {
            // 测试数据库连接
            String sql = "SELECT 1";
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
            return "数据库连接成功！测试结果: " + result;
        } catch (Exception e) {
            return "数据库连接失败: " + e.getMessage();
        }
    }
}