package com.controller;

import java.io.IOException;

import com.cookie.CookieUtil;
import com.data.UserDB;
import com.hash.Pbkdf2PasswordHashImpl;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/view/login.jsp";

        String action = request.getParameter("action");

        if (action == null) {
            action = "load";
        }

        if (action.equals("load")) {
            url = "/view/login.jsp";
        } else if (action.equals("login")) {
            // get parameters from the request
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String saveLogin = request.getParameter("save-password");

            System.out.println(saveLogin);

            String message;

            // store data in User object
            User selectedUser = UserDB.selectUser(email);

            if (selectedUser == null || !passwordHash.verify(password.toCharArray(), selectedUser.getPassword())) {
                message = "Incorrect username or password.";
                url = "/view/login.jsp";
                request.setAttribute("loginError", "true");
            } else {
                message = "";

                HttpSession session = request.getSession();
                session.setAttribute("user", selectedUser);

                Cookie emailCookie = new Cookie("emailCookie", email);
                emailCookie.setMaxAge(30 * 24 * 60 * 60);
                emailCookie.setPath("/");
                response.addCookie(emailCookie);

                response.sendRedirect(request.getContextPath() + "/");
                return;
            }

            // request.setAttribute("email", selectedUser);
            request.setAttribute("message", message);

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isLoggedIn(request, response)) {
            String url = "/view/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

    }

    public static boolean isLoggedIn(HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            Cookie[] cookies = request.getCookies();

            String email = CookieUtil.getCookieValue(cookies, "emailCookie");

            // if cookie doesn't exist, go to Registration page
            if (email == null || email.equals("")) {
                return false;
            } else {
                user = UserDB.selectUser(email);
                session.setAttribute("user", user);
                return true;
            }
        } else {
            return true;
        }
    }

}