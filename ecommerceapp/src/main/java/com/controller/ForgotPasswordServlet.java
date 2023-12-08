package com.controller;

import java.io.IOException;
import java.util.Random;

import com.data.UserDB;
import com.mail.MailSendTSL;
import com.model.User;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = UserDB.selectUser(email);

        if (user != null) {
            String resetCode = generateResetCode();
            String htmlContent = createHtmlContent(resetCode);
            try {
                MailSendTSL.sendEmail(email, "Password Reset Code", htmlContent);
                request.getSession().setAttribute("resetCode", resetCode); // Store reset code in session
                request.getSession().setAttribute("resetEmail", email); // Store user email in session
                request.setAttribute("message", "A reset code has been sent to your email.");
                request.setAttribute("emailSent", true); // Flag to indicate email has been sent
            } catch (MessagingException e) {
                e.printStackTrace();
                request.setAttribute("error", "Failed to send email.");
            }
        } else {
            request.setAttribute("error", "Email address not found.");
        }

        getServletContext().getRequestDispatcher("/view/forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoginServlet.isLoggedIn(request, response)) {
            String url = "/view/forgot-password.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

    }

    private String createHtmlContent(String resetCode) {
        return "Please reset your Fashi account password with this code: " + resetCode;
    }

    private String generateResetCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
}
