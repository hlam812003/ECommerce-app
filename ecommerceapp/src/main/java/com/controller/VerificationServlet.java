package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            request.setAttribute("loginError", "false");
            request.setAttribute("message", "Email address verified successfully.");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        } else {
            request.setAttribute("loginError", "true");
            request.setAttribute("message", "Incorrect verify link. Please reset password to verify your account.");
            response.sendRedirect(request.getContextPath() + "/login");

        }
    }
}