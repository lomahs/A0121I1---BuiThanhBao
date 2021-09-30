package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog findBlogById(int id);

    List<Blog> listBlog();

    void removeBlog(int id);

    void saveBlog(Blog blog);
}