package com.yang.myblog.service;

import com.yang.myblog.pojo.Blog;
import com.yang.myblog.queryvo.*;

import java.util.List;

/**
 * @author ：yangyin
 * @description：博客列表业务层接口
 * @date ：2021/3/15 17:32
 */
public interface BlogService {

    ShowBlog getBlogById(Long id);

    List<Blog> getAllBlog();

    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

    int getCommentCountById(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}
