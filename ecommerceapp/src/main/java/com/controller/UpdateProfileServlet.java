package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.hash.Pbkdf2PasswordHashImpl;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    private static Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("update-profile")) {

            HttpSession session = request.getSession();

            User selectedUser = (User) session.getAttribute("user");

            System.out.println(selectedUser.getEmail());

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Cookie[] cookies = request.getCookies();
            // String password = CookieUtil.getCookieValue(cookies, "password");
            // if (password == null) {
            //     password = request.getParameter("password");
            // }
            String password = request.getParameter("password");

            if (!passwordHash.verify(password.toCharArray(), selectedUser.getPassword())) {
                String message = "Incorrect password or the cookies have been changed";
                request.setAttribute("message", message);
                response.sendRedirect(request.getContextPath() + "/profile");
                return;
            }

            selectedUser.setFirstName(firstName);
            selectedUser.setLastName(lastName);
            UserDB.update(selectedUser);
        }

        response.sendRedirect(request.getContextPath() + "/profile");
        return;

    }

}