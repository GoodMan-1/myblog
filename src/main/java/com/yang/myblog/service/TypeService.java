package com.yang.myblog.service;

import com.yang.myblog.pojo.Type;

import java.util.List;

/**
 * @author ：yangyin
 * @description：文章分类业务层接口
 * @date ：2021/3/11 15:48
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);
}
