package com.yang.myblog.service;

import com.yang.myblog.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：yangyin
 * @description：博客评论业务层接口
 * @date ：2021/3/16 14:00
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    void deleteComment(Comment comment,Long id);
}
