package com.controller;

import java.io.IOException;

import com.payment.paypal.PaypalServices;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/paypal-review")
public class ReviewPaypalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ReviewPaypalServlet() {}

    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        try {
            PaypalServices paymentServices = new PaypalServices();
            Payment payment = paymentServices.getPaymentDetails(paymentId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);
            request.setAttribute("shippingAddress", shippingAddress);

            String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;

            request.getRequestDispatcher(url).forward(request, response);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/view/error.jsp");
        }      
    }
}
