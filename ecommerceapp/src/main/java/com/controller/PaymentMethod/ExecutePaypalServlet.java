package com.controller.PaymentMethod;

import java.io.IOException;

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
                    String htmlContent = "<html>\n"
                            + "<head>\n"
                            + "    <style>\n"
                            + "        body {\n"
                            + "            font-family: 'Open Sans', sans-serif;\n"
                            + "            background-color: #f3f4f6;\n"
                            + "            color: #1f2937;\n"
                            + "            margin: 0;\n"
                            + "            padding: 0;\n"
                            + "        }\n"
                            + "        .container {\n"
                            + "            max-width: 600px;\n"
                            + "            margin: 10px auto;\n"
                            + "            background-color: #ffffff;\n"
                            + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n"
                            + "        }\n"
                            + "        .header {\n"
                            + "            padding: 20px;\n"
                            + "            background-color: #f1f5f9;\n"
                            + "            text-align: center;\n"
                            + "        }\n"
                            + "        .header h1 {\n"
                            + "            margin: 0;\n"
                            + "            font-size: 24px;\n"
                            + "            font-weight: bold;\n"
                            + "            color: #111827;\n"
                            + "        }\n"
                            + "        .body {\n"
                            + "            padding: 20px;\n"
                            + "        }\n"
                            + "        .body h2 {\n"
                            + "            font-size: 20px;\n"
                            + "            font-weight: bold;\n"
                            + "            color: #111827;\n"
                            + "            margin-bottom: 15px;\n"
                            + "        }\n"
                            + "        .body p {\n"
                            + "            font-size: 16px;\n"
                            + "            line-height: 1.5;\n"
                            + "        }\n"
                            + "        .body .order-summary {\n"
                            + "            margin-top: 20px;\n"
                            + "        }\n"
                            + "        .body .order-summary .order-item {\n"
                            + "            display: flex;\n"
                            + "            justify-content: space-between;\n"
                            + "            margin-bottom: 10px;\n"
                            + "        }\n"
                            + "        .body .order-summary .order-item span {\n"
                            + "            font-size: 16px;\n"
                            + "            line-height: 1.5;\n"
                            + "        }\n"
                            + "        .body .order-summary .total {\n"
                            + "            border-top: 1px solid #e5e7eb;\n"
                            + "            margin-top: 20px;\n"
                            + "            padding-top: 20px;\n"
                            + "            display: flex;\n"
                            + "            justify-content: space-between;\n"
                            + "            font-weight: bold;\n"
                            + "            font-size: 18px;\n"
                            + "        }\n"
                            + "        .footer {\n"
                            + "            padding: 20px;\n"
                            + "            background-color: #f1f5f9;\n"
                            + "            text-align: center;\n"
                            + "        }\n"
                            + "        .footer p {\n"
                            + "            font-size: 14px;\n"
                            + "            color: #6b7280;\n"
                            + "        }\n"
                            + "    </style>\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "    <div class=\"container\">\n"
                            + "        <div class=\"header\">\n"
                            + "            <h1>Thanks for your order, " + invoice.getUser().getFirstName() + "</h1>\n"
                            + "            <p>Your order has been confirmed and it's currently being processed. Here are the details of your purchase:</p>\n"
                            + "        </div>\n"
                            + "        <div class=\"body\">\n"
                            + "            <h2>Order Details:</h2>\n"
                            + "            <div class=\"order-summary\">\n"
                            + "                <div class=\"order-item\">\n"
                            + "                    <span>Order number: #" + invoice.getInvoiceId() + "</span>\n"
                            + "                    <span>Order Date: " + invoice.getInvoiceDateTime() + "</span>\n"
                            + "                </div>\n";
                    Double subtotal = 0.0;
                    for (LineItem item : invoice.getItems()) {
                        subtotal += item.getTotal();
                        htmlContent += "                <div class=\"order-item\">\n"
                                + "                    <span>" + item.getItem().getName() + " &#215; "
                                + item.getQuantity() + "</span>\n"
                                + "                    <span>$" + item.getTotal() + "</span>\n"
                                + "                </div>\n";
                    }
                    Double tax = subtotal * 0.05;
                    Double shipping = subtotal * 0.01;

                    htmlContent += "                <div class=\"total\">\n"
                            + "                    <span>Subtotal</span>\n"
                            + "                    <span>$" + subtotal + "</span>\n"
                            + "                </div>\n"
                            + "                <div class=\"total\">\n"
                            + "                    <span>Tax</span>\n"
                            + "                    <span>$" + tax + " (5%)</span>\n"
                            + "                </div>\n"
                            + "                <div class=\"total\">\n"
                            + "                    <span>Shipping Fee</span>\n"
                            + "                    <span>$" + shipping + " (1%)</span>\n"
                            + "                </div>\n"
                            + "                <div class=\"total\">\n"
                            + "                    <span>Total</span>\n"
                            + "                    <span>$" + (subtotal + tax + shipping) + "</span>\n"
                            + "                </div>\n"
                            + "            </div>\n"
                            // + " <a href=\"#\" class=\"download-pdf\">Download pdf</a>\n"
                            + "        </div>\n"
                            + "        \n"
                            + "        <div class=\"footer\">\n"
                            + "            <p>This is not a payment receipt. It is an order summary to acknowledge the completion of the order. You will receive an order receipt when the payment is processed with payment information.</p>\n"
                            + "        </div>\n"
                            + "    </div>\n"
                            + "</body>\n"
                            + "</html>";

                    try {
                        MailSendTSL.sendEmail(user.getEmail(), "Fashi | Order Detail #" + invoice.getInvoiceId(),
                                htmlContent,
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
