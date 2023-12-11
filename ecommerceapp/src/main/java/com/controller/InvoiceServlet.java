package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.data.InvoiceDB;
import com.data.OrderDetailDB;
import com.model.Cart;
import com.model.Invoice;
import com.model.OrderDetail;
import com.model.User;
import com.payment.paypal.PaypalServices;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

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
            final Double TAX_RATE = 0.05;
            final Double SHIPPING_RATE = 0.01;
            Double subtotalAmount = cart.getTotal();
            Double taxAmount = subtotalAmount * TAX_RATE;
            Double shippingAmount = subtotalAmount * SHIPPING_RATE;
            Double total = subtotalAmount + taxAmount + shippingAmount;

            if (total <= 0) {
                request.setAttribute("errorMessage", "Total amount cannot be zero.");
                response.sendRedirect(request.getContextPath() + "/view/error.jsp");
                return;
            }

            Invoice invoice = new Invoice();
            invoice.setUser(user);
            invoice.setItems(cart.getItems());
            invoice.setInvoiceDateTime(LocalDateTime.now());
            InvoiceDB.insert(invoice);

            String emailAddress = user.getEmail();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();

            String companyName = request.getParameter("companyName");
            String countryName = request.getParameter("countryName");
            String streetAddress = request.getParameter("streetAddress");
            String postCode = request.getParameter("postCode");
            String cityName = request.getParameter("cityName");
            String phoneNumber = request.getParameter("phoneNumber");
            String paymentMethod = request.getParameter("paymentMethod");
            OrderDetail orderDetail = new OrderDetail(invoice, firstName, lastName, companyName, countryName,
                    streetAddress, postCode, cityName, emailAddress, phoneNumber, total, subtotalAmount, taxAmount,
                    shippingAmount, paymentMethod);
            OrderDetailDB.insert(orderDetail);

            if (paymentMethod.equals("cheque")) {
                PayerInfo payerInfo = new PayerInfo();
                payerInfo.setFirstName(orderDetail.getFirstName())
                        .setLastName(orderDetail.getLastName())
                        .setEmail(orderDetail.getEmailAddress());

                Details details = new Details();
                details.setShipping(String.format("%.2f", orderDetail.getShippingAmount()));
                details.setTax(String.format("%.2f", orderDetail.getTaxAmount()));
                details.setSubtotal(String.format("%.2f", orderDetail.getSubtotalAmount()));

                Amount amount = new Amount();
                amount.setTotal(String.format("%.2f", orderDetail.getTotalAmount()));
                amount.setCurrency("USD");
                amount.setDetails(details);

                Transaction transaction = new Transaction();
                transaction.setAmount(amount);
                transaction.setDescription("Order at Fashi");
                transaction.setCustom(orderDetail.getInvoice().getInvoiceId().toString());

                request.setAttribute("payer", payerInfo);
                request.setAttribute("transaction", transaction);

                String url = "/paypal-execute";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } else if (paymentMethod.equals("paypal")) {
                try {
                    PaypalServices paymentServices = new PaypalServices();
                    String approvalLink = paymentServices.authorizePayment(orderDetail);

                    response.sendRedirect(approvalLink);

                } catch (PayPalRESTException e) {
                    request.setAttribute("errorMessage", e.getMessage());
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/view/error.jsp");
                }
            }

            // response.sendRedirect(
            // request.getContextPath() + "/receipt?id=" +
            // InvoiceDB.findLastInvoiceByUser(user).getInvoiceId());
        } else {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user.getFirstName() == null || user.getLastName() == null) {
                response.sendRedirect(request.getContextPath() + "/profile");
                return;
            }

            ShopServlet.setCart(request, response);

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
