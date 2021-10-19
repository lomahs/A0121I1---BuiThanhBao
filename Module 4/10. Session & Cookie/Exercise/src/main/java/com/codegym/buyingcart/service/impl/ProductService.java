package com.codegym.buyingcart.service.impl;

import com.codegym.buyingcart.model.Product;
import com.codegym.buyingcart.repository.ProductRepository;
import com.codegym.buyingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getListProducts() {
        return repository.findAll();
    }
}