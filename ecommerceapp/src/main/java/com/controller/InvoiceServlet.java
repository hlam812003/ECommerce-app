package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.data.InvoiceDB;
import com.data.OrderDetailDB;
import com.model.Cart;
import com.model.Invoice;
import com.model.OrderDetail;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class InvoiceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null && !cart.getItems().isEmpty()) {
            Double subtotal = cart.getTotal();
            final Double taxRate = 0.05;
            Double total = subtotal * (1 + taxRate);

            Invoice invoice = new Invoice();
            invoice.setUser(user);
            invoice.setItems(cart.getItems());
            invoice.setInvoiceDateTime(LocalDateTime.now());
            InvoiceDB.insert(invoice);

            OrderDetail detail = new OrderDetail(invoice, request.getParameter("firstName"),
                    request.getParameter("lastName"), request.getParameter("companyName"),
                    request.getParameter("countryName"), request.getParameter("streetAddress"),
                    request.getParameter("postCode"), request.getParameter("cityName"),
                    request.getParameter("emailAddress"), request.getParameter("phoneNumber"),
                    total, subtotal, taxRate, request.getParameter("paymentMethod"));
            OrderDetailDB.insert(detail);

            response.sendRedirect(request.getContextPath() + "/receipt?id=" + InvoiceDB.findLastInvoiceByUser(user).getInvoiceId());
        }
        else {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            ShopServlet.setCart(request, response);

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null || cart.getItems().size() < 1) {
                response.sendRedirect(request.getContextPath() + "/shopping-cart");
                return;
            } else {
                String url = "/view/check-out.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

    }
}
