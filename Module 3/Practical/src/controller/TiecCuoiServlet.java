package controller;

import bean.TiecCuoi;
import service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class TiecCuoiServlet extends HttpServlet {
    Service service = new Service();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }

        switch (action){
            case "add":
                showAddForm(request,response);
                break;
            case "remove":

                break;
            default:
                showList(request,response);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }

        switch (action){
            case "add":
                addTiecCuoi(request,response);
                break;
            case "remove":

                break;
            default:
                showList(request,response);
                break;
        }
    }



    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TiecCuoi> list = service.xemCacTiecCuoi();

        request.setAttribute("danhSachTiec",list);
        request.getRequestDispatcher("list-tieccuoi.jsp").forward(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("them-tieccuoi.jsp");
    }

    private void addTiecCuoi(HttpServletRequest request, HttpServletResponse response) {
        Date ngayToChuc = Date.valueOf(request.getParameter("ngayToChuc"));
        String tenCoDau = request.getParameter("tenCoDau");
        String tenChuRe = request.getParameter("tenChuRe");
        int soLuongBan = Integer.parseInt(request.getParameter("soLuongBan"));
        int donGia = Integer.parseInt(request.getParameter("donGia"));

    }


}
