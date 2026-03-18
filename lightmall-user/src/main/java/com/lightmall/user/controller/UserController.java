package com.lightmall.user.controller;

import com.lightmall.user.model.Result;
import com.lightmall.user.model.LoginRequest;
import com.lightmall.user.model.RegisterRequest;
import com.lightmall.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register", produces = "application/json")
    public Result register(@ApiParam(name = "注册信息", required = true) @RequestBody RegisterRequest request) {
        logger.info("注册请求: {}", request.getUsername());
        try {
            Object result = userService.register(request);
            logger.info("注册成功，结果类型: {}", result.getClass());
            return Result.success(result);
        } catch (Exception e) {
            logger.error("注册失败: {}", e.getMessage());
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login", produces = "application/json")
    public Result login(@ApiParam(name = "登录信息", required = true) @RequestBody LoginRequest request) {
        logger.info("登录请求: {}", request.getUsername());
        try {
            Object result = userService.login(request);
            logger.info("登录成功，结果类型: {}", result.getClass());
            return Result.success(result);
        } catch (Exception e) {
            logger.error("登录失败: {}", e.getMessage());
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID获取用户信息")
    @GetMapping(value = "/get/{id}", produces = "application/json")
    public Result getById(@ApiParam(name = "用户ID", required = true) @PathVariable Long id) {
        logger.info("获取用户信息: {}", id);
        try {
            Object result = userService.getById(id);
            logger.info("获取成功，结果类型: {}", result.getClass());
            return Result.success(result);
        } catch (Exception e) {
            logger.error("获取失败: {}", e.getMessage());
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}