package com.lightmall.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lightmall.user.model.User;

public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}