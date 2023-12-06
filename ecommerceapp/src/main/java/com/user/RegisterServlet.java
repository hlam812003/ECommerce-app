package com.user;

import java.io.IOException;

import com.business.User;
import com.data.UserDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            // get parameters from the request
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm-password");

            String message;

            if (!password.equals(confirmPassword)) {
                message = "Those passwords didn't match. Try again";
                url = "/view/register.jsp";
            } else {
                // store data in User object
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);

                // validate the parameters
                if (UserDB.emailExists(user.getEmail())) {
                    message = "This email address already exists.<br>" +
                            "Please enter another email address.";
                    url = "/view/register.jsp";
                } else {
                    message = "";
                    url = "/login";
                    UserDB.insert(user);
                    System.out.println("Successful!");
                }
                request.setAttribute("user", user);
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
        String url = "/view/register.jsp";

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}