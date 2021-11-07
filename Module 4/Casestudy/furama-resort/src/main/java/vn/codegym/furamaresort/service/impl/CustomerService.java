package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.customer.Customer;
import vn.codegym.furamaresort.repository.CustomerRepository;
import vn.codegym.furamaresort.service.ICustomerService;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> listAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean deleteCustomerById(String id) {
        if (getCustomerById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Page<Customer> listAllCustomerByCustomerName(String name, Pageable pageable) {
        return customerRepository.findCustomerByCustomerNameContaining(name, pageable);
    }
}