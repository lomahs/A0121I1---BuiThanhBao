package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategory() {
        List<Category> list = new ArrayList<>();

        categoryRepository.findAll().forEach(list::add);
        return list;
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