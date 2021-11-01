package com.codegym.springsecurity.repository;


import com.codegym.springsecurity.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}