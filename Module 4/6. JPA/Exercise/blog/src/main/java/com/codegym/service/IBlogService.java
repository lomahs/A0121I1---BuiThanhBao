package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findBlogById(int id);

    List<Blog> listBlog();

    void removeBlog(int id);

    void saveBlog(Blog blog);
}