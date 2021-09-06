package controller;

import bean.employee.Employee;
import service.impl.EmployeeSvc;
import service.IEmployeeSvc;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeSvc service = new EmployeeSvc();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "showEditForm":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> list = service.readAllEmployees();

        request.setAttribute("listEmployee", list);
        request.getRequestDispatcher("employee/list-employee.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("employee/add-employee.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegree"));
        int divisionID = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");

        int id = service.addEmployee(
                name,
                birthday,
                idCard,
                salary,
                phone,
                email,
                address,
                positionId,
                educationDegreeId,
                divisionID,
                username
        );

        request.setAttribute("newEmployeeId", id);
        showListEmployee(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = service.getEmployeeById(id);

        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/edit-employee.jsp").forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionID = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegree"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");

        service.updateEmployee(
                id,
                name,
                birthday,
                idCard,
                salary,
                phone,
                email,
                address,
                positionID,
                educationDegreeId,
                divisionId,
                username
        );

        request.setAttribute("message", "Edit Successfully!");
        showEditForm(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        service.deleteEmployee(id);
        request.setAttribute("message", "Delete Successfully!");

        showListEmployee(request, response);
    }
}

