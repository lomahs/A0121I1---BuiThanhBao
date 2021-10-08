package com.example.cmsspringboot.service;


import com.example.cmsspringboot.service.impl.SimpleCustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = (CustomerService) new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}