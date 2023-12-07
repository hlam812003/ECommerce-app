package com.controller.PaymentMethod;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.payment.paypal.PaypalServices;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/paypal-execute")
public class ExecutePaypalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExecutePaypalServlet() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        try {
            PaypalServices paymentServices = new PaypalServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);

            response.sendRedirect(request.getContextPath() + "/view/receipt.jsp");

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/view/error.jsp");
        }
    }
}
