package com.controller;

import java.io.IOException;

import com.data.UserDB;
import com.model.User;

// import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
                user.setPassword(newPassword);
                user.setVerified(true);
                UserDB.update(user);
                session.removeAttribute("emailForReset");
                session.removeAttribute("resetCode");

                request.setAttribute("message", "Password has been successfully reset.");

                response.sendRedirect(request.getContextPath() + "/login");
                return;
            } else {
                request.setAttribute("error", "Error resetting password.");
                getServletContext().getRequestDispatcher("/view/reset-password.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Passwords do not match.");
            getServletContext().getRequestDispatcher("/view/reset-password.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralServlet.isLoaded(request, response);
        if (!LoginServlet.isLoggedIn(request, response)) {
            String url = "/view/reset-password.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

    }
}
