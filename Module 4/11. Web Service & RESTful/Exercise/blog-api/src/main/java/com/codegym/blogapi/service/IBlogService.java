package com.codegym.blogapi.service;

import com.codegym.blogapi.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Blog findBlogById(int id);

    List<Blog> listBlog();

    void removeBlog(int id);

    void saveBlog(Blog blog);

    List<Blog> getBlogByCategory(int id);
}