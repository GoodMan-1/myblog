package com.yang.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：yangyin
 * @description：留言实体类
 * @date ：2021/3/16 12:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    // 回复评论
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;
}
