package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
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
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }
}