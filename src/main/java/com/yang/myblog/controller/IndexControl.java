package com.yang.myblog.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.myblog.NotFoundException;
import com.yang.myblog.dao.BlogDao;
import com.yang.myblog.pojo.Comment;
import com.yang.myblog.queryvo.DetailedBlog;
import com.yang.myblog.queryvo.FirstPageBlog;
import com.yang.myblog.queryvo.RecommendBlog;
import com.yang.myblog.service.BlogService;
import com.yang.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class IndexControl {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    // 分页查询博客列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, RedirectAttributes attributes) {
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> allFirstPageBlog = blogService.getFirstPageBlog();
        List<RecommendBlog> recommendedBlogs = blogService.getAllRecommendBlog();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlogs);
        return "index";
    }

    // 搜索博客
    @PostMapping("/search")
    public String search(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam String query) {
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    // 跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }

    // 博客信息
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model) {
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal", blogTotal);
        model.addAttribute("blogViewTotal", blogViewTotal);
        model.addAttribute("blogCommentTotal", blogCommentTotal);
        model.addAttribute("blogMessageTotal", blogMessageTotal);
        return "index :: blogMessage";
    }

}
