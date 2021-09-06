package controller;

import bean.customer.Customer;
import bean.employee.Employee;
import service.ICustomerSvc;
import service.impl.CustomerSvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerSvc service = new CustomerSvc();

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
                showListCustomers(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "showEditForm":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showListCustomers(request, response);
                break;
        }
    }

    private void showListCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = service.readAllCustomers();

        request.setAttribute("listCustomer", list);
        request.getRequestDispatcher("customer/list-customer.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("customer/add-customer.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int typeId = Integer.parseInt(request.getParameter("type"));

        int id = service.addCustomer(
                typeId,
                name,
                birthday,
                gender,
                idCard,
                phone,
                email,
                address
        );

        request.setAttribute("newCustomerId", id);
        showListCustomers(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.getCustomerById(id);

        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit-customer.jsp").forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int typeId = Integer.parseInt(request.getParameter("type"));

        service.updateCustomer(
                id,
                typeId,
                name,
                birthday,
                gender,
                idCard,
                phone,
                email,
                address
        );

        request.setAttribute("message", "Edit Successfully!");
        showEditForm(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        service.deleteCustomer(id);
        request.setAttribute("message", "Delete Successfully!");

        showListCustomers(request, response);
    }
}
