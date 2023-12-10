package com.controller.Admin;

import java.io.IOException;
import com.data.UserDB;
import com.model.User;
import com.hash.Pbkdf2PasswordHashImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
    private static Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User adminUser = UserDB.selectUser(email);

        if (adminUser != null && adminUser.isAdmin() && passwordHash.verify(password.toCharArray(), adminUser.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", adminUser);

            Cookie emailCookie = new Cookie("adminEmail", email);
            emailCookie.setMaxAge(60 * 60 * 24 * 30);
            emailCookie.setPath("/");
            response.addCookie(emailCookie);

            request.setAttribute("loginSuccess", true);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            request.setAttribute("loginError", "Invalid email or password");
            String url = "/view/admin/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String url = "/view/admin/login.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
