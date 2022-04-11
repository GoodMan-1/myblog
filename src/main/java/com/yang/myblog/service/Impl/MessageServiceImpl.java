package com.yang.myblog.service.Impl;

import com.yang.myblog.dao.MessageDao;
import com.yang.myblog.pojo.Message;
import com.yang.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：yangyin
 * @description：留言业务层接口实现类
 * @date ：2021/3/19 17:33
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    // 存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    /**
     * @author: yangyin
     * @description: 查询留言
     * @date: 2021/3/19 17:42
     * @param null
     * @return 留言消息
     */
    @Override
    public List<Message> listMessage() {
        List<Message> messages = messageDao.findByParentIdNull(Long.parseLong("-1"));
        for (Message message : messages) {
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageDao.findByParentIdNotNull(id);
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    /**
     * @author: yangyin
     * @description: 查询出子留言
     * @date: 2021/3/19 17:42
     * @param childMessages：所有子留言 parentNickname1：父留言的姓名
     * @return 
     */
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if (childMessages.size() > 0) {
            for (Message childMessage : childMessages) {
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    /**
     * @author: yangyin
     * @description: 循环迭代找出子集回复
     * @date: 2021/3/19 17:43
     * @param childId：子留言的id parentNickname1：子留言的姓名
     * @return 
     */
    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replyMessages = messageDao.findByReplyId(childId);
        if (replyMessages.size() > 0) {
            for (Message replyMessage : replyMessages) {
                String parentNickname = replyMessage.getNickname();
                replyMessage.setParentNickname(parentNickname1);
                Long replyId = replyMessage.getId();
                tempReplys.add(replyMessage);
                recursively(replyId, parentNickname);
            }
        }
    }

    @Override
    public int saveMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDao.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessage(id);
    }
}
