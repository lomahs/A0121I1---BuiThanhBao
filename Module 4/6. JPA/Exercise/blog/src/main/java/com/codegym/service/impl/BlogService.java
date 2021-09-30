package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findBlogById(id);
    }

    @Override
    public List<Blog> listBlog() {
        return blogRepository.listBlog();
    }

    @Override
    public void removeBlog(int id) {
        blogRepository.removeBlog(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.saveBlog(blog);
    }
}