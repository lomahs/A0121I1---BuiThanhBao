package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.customer.CustomerType;

import java.util.List;

@Service
public interface ICustomerTypeService {
    List<CustomerType> listAllCustomerTypes();
}