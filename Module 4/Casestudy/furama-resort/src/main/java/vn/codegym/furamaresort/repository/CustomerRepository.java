package vn.codegym.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furamaresort.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable);
}