package com.codegym.springsecurity.service;



import com.codegym.springsecurity.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    void saveCategory(Category category);

    List<Category> listCategory();

    void removeCategory(int id);

    Category findCategoryById(int id);
}