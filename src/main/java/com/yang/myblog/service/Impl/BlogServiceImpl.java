package com.yang.myblog.service.Impl;

import com.yang.myblog.NotFoundException;
import com.yang.myblog.dao.BlogDao;
import com.yang.myblog.pojo.Blog;
import com.yang.myblog.queryvo.*;
import com.yang.myblog.service.BlogService;
import com.yang.myblog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：yangyin
 * @description：博客列表业务层接口实现类
 * @date ：2021/3/15 17:34
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public List<BlogQuery> getAllBlogQuery() {
        return blogDao.getAllBlogQuery();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog) {
        return blogDao.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogDao.updateViews(id);
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    @Override
    public int updateViews(Long id) {
        return blogDao.updateViews(id);
    }

    @Override
    public int getCommentCountById(Long id) {
        return blogDao.getCommentCountById(id);
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }
}
