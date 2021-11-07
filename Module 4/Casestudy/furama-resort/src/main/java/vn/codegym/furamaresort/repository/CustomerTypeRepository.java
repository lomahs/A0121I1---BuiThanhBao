package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furamaresort.model.customer.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}