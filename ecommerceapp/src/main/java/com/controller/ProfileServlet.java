package com.controller;

import java.io.IOException;

import com.cookie.CookieUtil;
import com.data.UserDB;
import com.hash.Pbkdf2PasswordHashImpl;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            String url = "/view/user-profile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
