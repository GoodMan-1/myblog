package com.yang.myblog.controller.admin;

import com.yang.myblog.pojo.User;
import com.yang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author ：yangyin
 * @description：用户登录控制器
 * @date ：2021/3/10 21:03
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    
    /**
     * @author: yangyin
     * @description: 跳转登录页面
     * @date: 2021/3/10 21:31
     * @param null
     * @return: 返回登录页面
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }
    
    /**
     * @author: yangyin
     * @description: 登录校验
     * @date: 2021/3/10 21:34
     * @param username:用户名 password:密码 session:session域 attributes:返回页面消息
     * @return 登录成功跳转登录成功页面，登录失败返回登录页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }
    
    /**
     * @author: yangyin
     * @description: 注销
     * @date: 2021/3/10 21:36
     * @param session:session域
     * @return 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
