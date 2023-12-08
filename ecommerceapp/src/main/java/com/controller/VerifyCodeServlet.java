package com.controller;

import java.io.IOException;
// import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/verify-code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String enteredCode = request.getParameter("code");
        HttpSession session = request.getSession();
        String resetCode = (String) session.getAttribute("resetCode");
        String resetEmail = (String) session.getAttribute("resetEmail");

        if (enteredCode != null && enteredCode.equals(resetCode)) {
            session.setAttribute("emailForReset", resetEmail);
            response.sendRedirect(request.getContextPath() + "/view/reset-password.jsp");
        } else {
            request.setAttribute("error", "Invalid code entered.");
            getServletContext().getRequestDispatcher("/view/forgot-password.jsp").forward(request, response);
        }
    }
}
