package com.yang.myblog.service;

import com.yang.myblog.pojo.User;

public interface UserService {

    User checkUser(String username, String password);
}
