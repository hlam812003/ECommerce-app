package com.controller.Admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Thực hiện các xử lý kiểm tra, như kiểm tra xem người dùng đã đăng nhập chưa
        
        // Chuyển tiếp đến trang đăng nhập của quản trị viên
        String url = "/view/admin/login.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập, xác thực người dùng
        // Nếu đăng nhập thành công, chuyển hướng tới trang quản trị
        // Nếu không thành công, hiển thị thông báo lỗi và quay lại trang đăng nhập

        // Ví dụ về chuyển hướng
        // response.sendRedirect(request.getContextPath() + "/admin");
    }
}
