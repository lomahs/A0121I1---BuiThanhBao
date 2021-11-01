package com.codegym.springsecurity.service;


import com.codegym.springsecurity.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Blog findBlogById(int id);

    Page<Blog> listBlog(Pageable pageable);

    void removeBlog(int id);

    void saveBlog(Blog blog);

    Page<Blog> findAllByTitleContaining(String title,Pageable pageable);

}