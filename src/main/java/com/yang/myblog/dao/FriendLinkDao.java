package com.yang.myblog.dao;

import com.yang.myblog.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：yangyin
 * @description：友链持久层接口
 * @date ：2021/3/19 19:30
 */
@Mapper
public interface FriendLinkDao {

    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
