package service;

import bean.employee.Employee;
import repository.EmployeeRepository;

import java.sql.Date;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository repository = new EmployeeRepository();

    @Override
    public void addEmployee(
            String name,
            Date birthday,
            String idCard,
            double salary,
            String phone,
            String email,
            String address,
            int positionID,
            int educationDegreeID,
            int divisionID,
            String username) {
        repository.addEmployee(
                name,
                birthday,
                idCard,
                salary,
                phone,
                email,
                address,
                positionID,
                educationDegreeID,
                divisionID,
                username);
    }

    @Override
    public List<Employee> readAllEmployees() {
        return repository.readAllEmployees();
    }

    @Override
    public void updateEmployee(int idEditedEmployee,
                               String name,
                               Date birthday,
                               String idCard,
                               double salary,
                               String phone,
                               String email,
                               String address,
                               int positionID,
                               int educationDegreeID,
                               int divisionID,
                               String username) {
        repository.updateEmployee(idEditedEmployee,
                name,
                birthday,
                idCard,
                salary,
                phone,
                email,
                address,
                positionID,
                educationDegreeID,
                divisionID,
                username);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteEmployee(id);
    }
}
