package com.xuanxuan.authserver.service;


import com.xuanxuan.authserver.model.UserInfoModel;
import com.xuanxuan.authserver.entity.User;


public interface UserService {
    UserInfoModel saveUser(User user);

    User findByEmail(String email);
}
