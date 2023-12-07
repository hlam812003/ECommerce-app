package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/view/register.jsp";

        String action = request.getParameter("action");

        if (action == null) {
            action = "load";
        }

        if (action.equals("load")) {
            url = "/view/register.jsp";
        } else if (action.equals("register")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm-password");

            String message;

            if (!password.equals(confirmPassword)) {
                message = "Those passwords didn't match. Try again.";
                url = "/view/register.jsp";
            } else {
                User user = UserDB.selectUser(email);

                if (user != null) {
                    message = "This email address already exists.<br>" +
                            "Please enter another email address.";
                    url = "/view/register.jsp";
                } else {
                    message = "";

                    user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    UserDB.insert(user);

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    Cookie emailCookie = new Cookie("email", email);
                    emailCookie.setMaxAge(30 * 24 * 60 * 60);
                    emailCookie.setPath("/");
                    response.addCookie(emailCookie);

                    response.sendRedirect(request.getContextPath() + "/");
                    return;
                }
                // request.setAttribute("user", user);
            }
            request.setAttribute("message", message);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoginServlet.isLoggedIn(request, response)) {
            String url = "/view/register.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
    }

}