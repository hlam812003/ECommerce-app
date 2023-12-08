package com.controller;
import com.model.User;
import com.data.UserDB;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        
        User user = UserDB.getUserByEmail(email);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            UserDB.update(user);
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("error", "User not found.");
        }
        getServletContext().getRequestDispatcher("/view/user-profile.jsp").forward(request, response);
    }
}
