package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/verify")
public class VerificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String code = request.getParameter("code");
        User user = UserDB.getUserByVerificationCode(code);

        if (user != null && !user.isVerified()) {
            user.setVerified(true);
            UserDB.update(user);
            // Chuyển hướng đến trang đăng nhập với thông báo thành công
        } else {
            // Xử lý trường hợp mã xác thực không hợp lệ
        }
    }
}