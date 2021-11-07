package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Employee;
import vn.codegym.furamaresort.repository.EmployeeRepository;
import vn.codegym.furamaresort.service.IEmployeeService;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Page<Employee> listAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.getUser().setPassword(bCryptPasswordEncoder.encode(employee.getUser().getPassword()));

        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        if (getEmployeeById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> listAllEmployeeByEmployeeName(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name, pageable);
    }
}