package com.codegym.blogapi.repository;

import com.codegym.blogapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select cat from Category as cat")
    public List<Category> getAllCategory();
}