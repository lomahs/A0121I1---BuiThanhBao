package com.codegym.blogapi.service;

import com.codegym.blogapi.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    void saveCategory(Category category);

    List<Category> listCategory();

    void removeCategory(int id);

    Category findCategoryById(int id);
}