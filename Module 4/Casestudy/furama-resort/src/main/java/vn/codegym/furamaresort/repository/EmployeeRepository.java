package vn.codegym.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);
}