package com.controller;

import java.io.IOException;

import com.data.InvoiceDB;
import com.data.OrderDetailDB;
import com.model.Invoice;
import com.model.OrderDetail;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/receipt")
public class ReceiptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralServlet.isLoaded(request, response);
        if (LoginServlet.isLoggedIn(request, response)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            Long invoiceId = Long.parseLong(request.getParameter("id"));

            Invoice invoice = InvoiceDB.findInvoiceById(invoiceId);
            OrderDetail detail = OrderDetailDB.findDetailById(invoiceId);

            if (invoice.getUser().getUserId().equals(user.getUserId()) == false || invoice == null) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }

            request.setAttribute("invoice", invoice);
            request.setAttribute("detail", detail);

            String url = "/view/receipt.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
    }
}
