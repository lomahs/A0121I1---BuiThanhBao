package repository;

import bean.employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static util.DBContext.getConnection;

public class EmployeeRepository implements IEmployeeRepository {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private final String INSERT_EMPLOYEE = "INSERT INTO employee (" +
            "employee_name, " +
            "employee_birthday, " +
            "employee_id_card, " +
            "employee_salary, " +
            "employee_phone, " +
            "employee_email, " +
            "employee_address, " +
            "position_id, " +
            "education_degree_id, " +
            "division_id, " +
            "username) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee;";
    private final String UPDATE_EMPLOYEE = "";
    private final String DELETE_EMPLOYEE = "";


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

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(INSERT_EMPLOYEE);

            pstmt.setString(1, name);
            pstmt.setDate(2, birthday);
            pstmt.setString(3, idCard);
            pstmt.setDouble(4, salary);
            pstmt.setString(5, phone);
            pstmt.setString(6, email);
            pstmt.setString(7, address);
            pstmt.setInt(8, positionID);
            pstmt.setInt(9, educationDegreeID);
            pstmt.setInt(10, divisionID);
            pstmt.setString(11, username);

            pstmt.executeUpdate();

            System.out.println(pstmt);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error when inserting!!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> readAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SELECT_ALL_EMPLOYEE);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getDate("employee_birthday"),
                        rs.getString("employee_id_card"),
                        rs.getDouble("em"),

                        ))
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
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

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
