package com.controller.PaymentMethod;

import java.io.IOException;
import java.time.LocalDateTime;

import com.controller.LoginServlet;
import com.data.InvoiceDB;
import com.mail.MailSendTSL;
import com.model.Invoice;
import com.model.LineItem;
import com.model.User;
import com.payment.paypal.PaypalServices;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/paypal-execute")
public class ExecutePaypalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExecutePaypalServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            String paymentId = request.getParameter("paymentId");
            String payerId = request.getParameter("PayerID");

            try {
                PayerInfo payerInfo = new PayerInfo();
                Transaction transaction = new Transaction();

                if (paymentId != null && payerId != null) {
                    PaypalServices paymentServices = new PaypalServices();
                    Payment payment = paymentServices.executePayment(paymentId, payerId);
                    payerInfo = payment.getPayer().getPayerInfo();
                    transaction = payment.getTransactions().get(0);
                    request.setAttribute("transaction", transaction);
                    request.setAttribute("payer", payerInfo);
                } else {
                    payerInfo = ((PayerInfo) request.getAttribute("payer"));
                    transaction = ((Transaction) request.getAttribute("transaction"));
                }

                Invoice invoice = InvoiceDB.findInvoiceById(Long.parseLong(transaction.getCustom()));
                invoice.setIsProcessed(true);
                InvoiceDB.update(invoice);

                if (user != null) {
                    String htmlContent = "<html>"
                            + "<head>"
                            + "<style>"
                            + "table { width: 100%; border-collapse: collapse; }"
                            + "th, td { border: 1px solid black; padding: 8px; text-align: left; }"
                            + "</style>"
                            + "</head>"
                            + "<body>"
                            + "<h2>Invoice #" + invoice.getInvoiceId() + "</h2>"
                            + "<table>"
                            + "<tr><th>Product</th><th>Quantity</th><th>Price</th></tr>";
                    Double total = 0.0;
                    for (LineItem item : invoice.getItems()) {
                        total += item.getQuantity() * item.getItem().getPrice();
                        htmlContent += "<tr><td>" + item.getItem().getName() + "</td><td>" + item.getQuantity()
                                + "</td><td>" + item.getQuantity() * item.getItem().getPrice() + "</td></tr>";
                    }
                    htmlContent += "<tr><td colspan='2'>Subtotal</td><td>" + String.valueOf(total) + "</td></tr>"
                            + "<tr><td colspan='2'>Tax</td><td>" + String.valueOf(total * 0.05) + "</td></tr>"
                            + "<tr><td colspan='2'>Shipping</td><td>" + String.valueOf(total * 0.01) + "</td></tr>"
                            + "<tr><td colspan='2'>Total</td><td>" + String.valueOf(total * 1.06) + "</td></tr>"
                            + "</table>"
                            + "</body>"
                            + "</html>";
                    try {
                        MailSendTSL.sendEmail(user.getEmail(), "Order Detail " + LocalDateTime.now(), htmlContent,
                                null);
                        request.setAttribute("message", "A detailed invoice information has been sent to your email.");
                        request.setAttribute("emailSent", true); // Flag to indicate email has been sent
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        request.setAttribute("error", "Failed to send email.");
                    }
                } else {
                    request.setAttribute("error", "Email address not found.");
                }

                String url = "/view/receipt.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);

            } catch (PayPalRESTException ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                ex.printStackTrace();
                String url = "/view/error.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
    }
}
