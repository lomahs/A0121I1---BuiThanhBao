package vn.codegym.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.customer.Customer;

import java.util.Optional;

@Service
public interface ICustomerService {
    Customer saveCustomer(Customer customer);

    Page<Customer> listAllCustomers(Pageable pageable);

    Optional<Customer> getCustomerById(String id);

    boolean deleteCustomerById(String id);

    Page<Customer> listAllCustomerByCustomerName(String name, Pageable pageable);

}