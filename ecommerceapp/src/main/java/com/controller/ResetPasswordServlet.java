package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.hash.Pbkdf2PasswordHashImpl;
import com.model.User;

// import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        HttpSession session = request.getSession();
        String emailForReset = (String) session.getAttribute("emailForReset");

        if (newPassword != null && newPassword.equals(confirmPassword)) {
            User user = UserDB.selectUser(emailForReset);
            if (user != null) {
                user.setPassword(new Pbkdf2PasswordHashImpl().generate(newPassword.toCharArray()));
                UserDB.update(user);
                session.removeAttribute("emailForReset");
                session.removeAttribute("resetCode");
                
                request.setAttribute("message", "Password has been successfully reset.");
                getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Error resetting password.");
                getServletContext().getRequestDispatcher("/view/reset-password.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Passwords do not match.");
            getServletContext().getRequestDispatcher("/view/reset-password.jsp").forward(request, response);
        }        
    }
}
