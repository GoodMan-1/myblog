package com.yang.myblog.controller;

import com.yang.myblog.queryvo.BlogQuery;
import com.yang.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ：yangyin
 * @description：时间轴页面显示控制器
 * @date ：2021/3/16 13:38
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model) {
        List<BlogQuery> blogs = blogService.getAllBlogQuery();
        model.addAttribute("blogs", blogs);
        System.out.println(blogs.get(0));
        return "archives";
    }
}
