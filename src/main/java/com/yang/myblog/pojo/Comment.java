package com.yang.myblog.pojo;

import com.yang.myblog.queryvo.DetailedBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：yangyin
 * @description：评论实体类
 * @date ：2021/3/9 17:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;

    // 头像
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;

    // 回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private boolean adminComment;

    private DetailedBlog blog;
}
