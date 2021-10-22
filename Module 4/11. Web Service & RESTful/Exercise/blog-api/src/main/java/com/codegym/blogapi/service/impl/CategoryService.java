package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.model.Category;
import com.codegym.blogapi.repository.IBlogRepository;
import com.codegym.blogapi.repository.ICategoryRepository;
import com.codegym.blogapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategory() {

        return new ArrayList<>(categoryRepository.findAll());
    }

    @Override
    public void removeCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}