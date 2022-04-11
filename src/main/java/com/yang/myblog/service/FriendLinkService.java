package com.yang.myblog.service;

import com.yang.myblog.pojo.FriendLink;

import java.util.List;

/**
 * @author ：yangyin
 * @description：友链业务层接口
 * @date ：2021/3/19 19:39
 */
public interface FriendLinkService {

    //查询所有友链
    List<FriendLink> listFriendLink();

    //友链新增
    int saveFriendLink(FriendLink friendLink);

    //根据id查询友链
    FriendLink getFriendLink(Long id);

    //根据网址查询友链
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    //编辑修改友链
    int updateFriendLink(FriendLink friendLink);

    //删除友链
    void deleteFriendLink(Long id);

}
