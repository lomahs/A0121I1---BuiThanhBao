package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.customer.CustomerType;
import vn.codegym.furamaresort.repository.CustomerTypeRepository;
import vn.codegym.furamaresort.service.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    public CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> listAllCustomerTypes() {
        return customerTypeRepository.findAll();
    }
}