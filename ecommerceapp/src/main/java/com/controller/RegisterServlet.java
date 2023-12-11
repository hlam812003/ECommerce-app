package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import com.data.UserDB;
import com.hash.Pbkdf2PasswordHashImpl;
import com.mail.MailSendTSL;
import com.model.User;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static Pbkdf2PasswordHashImpl verifyHash = new Pbkdf2PasswordHashImpl();

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
            } else if (UserDB.isEmailExists(email)) {
                message = "This email address already exists. Please enter another email address.\nTips: Reset password to verify your account.";
                url = "/view/register.jsp";
            } else {
                // Tạo mã xác thực
                String verificationCode = UUID.randomUUID().toString();

                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setVerificationCode(verificationCode);
                UserDB.insert(user);

                // Send Verification
                String subject = "Account Verification";
                String content = "Please click on the following link to verify your account: "
                        + "<a href='http://localhost:8080/verify?code="
                        + URLEncoder.encode(verifyHash.generate((email + verificationCode).toCharArray()),
                                StandardCharsets.UTF_8.toString())
                        + "'>Verify Account</a>";

                try {
                    MailSendTSL.sendEmail(email, subject, content, null);
                    message = "Verification email sent. Please check your email to verify your account.";
                } catch (MessagingException e) {
                    message = "Failed to send verification email.";
                    e.printStackTrace();
                }

                url = "/view/verify-account.jsp";
            }

            request.setAttribute("message", message);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralServlet.isLoaded(request, response);
        if (!LoginServlet.isLoggedIn(request, response)) {
            String url = "/view/register.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
    }

}