package com.yang.myblog.controller;

import com.yang.myblog.pojo.Message;
import com.yang.myblog.pojo.User;
import com.yang.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：yangyin
 * @description：留言页面控制器
 * @date ：2021/3/19 17:45
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${message.avatar}")
    private String avatar;

    @GetMapping("/message")
    public String message() {
        return "message";
    }

    @GetMapping("/messagecomment")
    public String messages(Model model) {
        List<Message> messages = messageService.listMessage();
        model.addAttribute("messages", messages);
        return "message :: messageList";
    }

    @PostMapping("/message")
    public String post(Message message, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {
            message.setAvatar(avatar);
        }
        if (message.getParentMessage().getId() != null) {
            message.setParentMessageId(message.getParentMessage().getId());
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessage();
        model.addAttribute("messages", messages);
        return "message :: messageList";
    }

    @GetMapping("/messages/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes, Model model) {
        messageService.deleteMessage(id);
        return "redirect:/message";
    }
}
