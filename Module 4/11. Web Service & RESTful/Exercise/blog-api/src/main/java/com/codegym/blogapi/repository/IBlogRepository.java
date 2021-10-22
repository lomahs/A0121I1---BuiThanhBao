package com.codegym.blogapi.repository;

import com.codegym.blogapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> getBlogByCategoryId(int idCategory);
}