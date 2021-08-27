package repository;

import bean.employee.Employee;

import java.sql.Date;
import java.util.List;

public interface IEmployeeRepository {

    void addEmployee(
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
            String username);

    List<Employee> readAllEmployees();

    void updateEmployee(
            int idEditedEmployee,
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
            String username
    );

    void deleteEmployee(int id);
}
