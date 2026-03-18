package com.lightmall.user.service;

import com.lightmall.user.model.User;
import com.lightmall.user.model.LoginRequest;
import com.lightmall.user.model.LoginResponse;
import com.lightmall.user.model.RegisterRequest;

public interface UserService {
    User register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    User getById(Long id);
}