package controller;

import bean.employee.Employee;
import service.EmployeeService;
import service.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            default:
                showListEmployee(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> list = service.readAllEmployees();

        request.setAttribute("listEmployee", list);
        request.getRequestDispatcher("employee/list-employee.jsp").forward(request, response);
    }
}
