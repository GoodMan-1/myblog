package com.yang.myblog.service.Impl;

import com.yang.myblog.dao.UserDao;
import com.yang.myblog.pojo.User;
import com.yang.myblog.service.UserService;
import com.yang.myblog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yangyin
 * @description：TODO
 * @date ：2021/3/10 21:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {

        return userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
    }
}
