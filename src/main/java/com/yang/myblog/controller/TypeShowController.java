package com.yang.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.myblog.pojo.Type;
import com.yang.myblog.queryvo.FirstPageBlog;
import com.yang.myblog.service.BlogService;
import com.yang.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：yangyin
 * @description：分类页面显示控制器
 * @date ：2021/3/17 18:43
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    // 分页查询分类
    @GetMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @PathVariable Long id, Model model) {
        List<Type> types = typeService.getAllTypeAndBlog();
        if (id == -1) {
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        List<FirstPageBlog> blogs = blogService.getByTypeId(id);

        PageHelper.startPage(pageNum, 10000);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activateTypeId", id);
        return "types";
        
    }
}
