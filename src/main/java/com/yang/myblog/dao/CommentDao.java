package com.yang.myblog.dao;

import com.yang.myblog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：yangyin
 * @description：评论持久层接口
 * @date ：2021/3/16 13:50
 */
@Mapper
public interface CommentDao {

    //根据创建时间倒序来排
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    //查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    List<Comment> findByBlogIdAndReplyId(@Param("blogId") Long blogId, @Param("childId") Long childId);

    //添加一个评论
    int saveComment(Comment comment);

    //删除评论
    void deleteComment(Long id);
}
