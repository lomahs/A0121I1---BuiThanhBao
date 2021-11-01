package com.codegym.springsecurity.repository;

import com.codegym.springsecurity.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}