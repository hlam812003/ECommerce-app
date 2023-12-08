package com.controller;

import java.io.IOException;
import java.util.Random;

import com.mail.MailSendTSL;
import com.data.UserDB;
import com.model.User;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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

    private String createHtmlContent(String resetCode) {
        return null;
    }

    private String generateResetCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
}
