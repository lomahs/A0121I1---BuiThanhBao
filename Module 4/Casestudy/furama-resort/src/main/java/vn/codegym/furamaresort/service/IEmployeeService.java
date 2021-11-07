package vn.codegym.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Employee;

import java.util.Optional;

@Service
public interface IEmployeeService {
    Page<Employee> listAllEmployees(Pageable pageable);

    Employee saveEmployee(Employee employee);

    boolean deleteEmployeeById(String id);

    Optional<Employee> getEmployeeById(String id);

    Page<Employee> listAllEmployeeByEmployeeName(String name, Pageable pageable);

}