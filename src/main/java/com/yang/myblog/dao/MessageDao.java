package com.yang.myblog.dao;

import com.yang.myblog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：yangyin
 * @description：留言持久层接口
 * @date ：2021/3/19 17:21
 */
@Mapper
public interface MessageDao {

    // 添加一个评论
    int saveMessage(Message message);

    // 查询父级评论
    List<Message> findByParentIdNull(@Param("parentId") Long parentId);

    // 查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    // 查询二级以及所有子集回复
    List<Message> findByReplyId(@Param("childId") Long childId);

    // 删除评论
    void deleteMessage(Long id);
}
