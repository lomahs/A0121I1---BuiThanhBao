package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.model.Blog;
import com.codegym.blogapi.repository.IBlogRepository;
import com.codegym.blogapi.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> listBlog() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public void removeBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getBlogByCategory(int id) {
        return blogRepository.getBlogByCategoryId(id);
    }
}