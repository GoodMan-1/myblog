package com.yang.myblog.dao;

import com.yang.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
