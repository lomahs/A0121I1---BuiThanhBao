package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    void saveCategory(Category category);

    List<Category> listCategory();

    void removeCategory(int id);

    Category findCategoryById(int id);
}