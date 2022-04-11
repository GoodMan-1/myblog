package com.yang.myblog.service;

import com.yang.myblog.pojo.Message;

import java.util.List;

/**
 * @author ：yangyin
 * @description：留言业务层接口
 * @date ：2021/3/19 17:32
 */
public interface MessageService {

    // 查询留言列表
    List<Message> listMessage();

    // 保存留言
    int saveMessage(Message message);

    // 删除留言
    void deleteMessage(Long id);
}
