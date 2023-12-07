package com.controller;
import com.data.CartDB;
import com.data.InvoiceDB;
import com.model.Cart;
import com.model.Invoice;
import com.model.User;
import java.io.IOException;
import java.util.Date;

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

        Cart cart = CartDB.findCartByUser(user);
        if (cart != null && !cart.getItems().isEmpty()) {
            Invoice invoice = new Invoice();
            invoice.setUser(user);
            invoice.setItems(cart.getItems());
            invoice.setInvoiceDateTime(new Date());
            invoice.setInvoiceId(generateInvoiceId());

            // Test thôi có gì ô làm rồi chỉnh lại nhé!
            double shippingFee = 30.0;
            double totalAmount = cart.getTotalPrice() + shippingFee;

            // Lưu hóa đơn
            InvoiceDB.insert(invoice);

            // Cập nhật session...
        }

        // response.sendRedirect("view/order-confirmation.jsp");
    }

    private String generateInvoiceId() {
        return "INV" + System.currentTimeMillis(); // Test
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/view/check-out.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
