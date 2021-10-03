package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog findBlogById(int id);

    Page<Blog> listBlog(Pageable pageable);

    void removeBlog(int id);

    void saveBlog(Blog blog);

    Page<Blog> findAllByTitleContaining(String title,Pageable pageable);

}