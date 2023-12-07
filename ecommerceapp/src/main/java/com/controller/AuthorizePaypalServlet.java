package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.OrderDetail;
import com.payment.paypal.PaypalServices;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/paypal-authorize")
public class AuthorizePaypalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthorizePaypalServlet() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String companyName = request.getParameter("companyName");
        String countryName = request.getParameter("countryName");
        String streetAddress = request.getParameter("streetAddress");
        String postCode = request.getParameter("postCode");
        String cityName = request.getParameter("cityName");
        String emailAddress = request.getParameter("emailAddress");
        String phoneNumber = request.getParameter("phoneNumber");

        String subtotal = request.getParameter("subtotal");
        String shipping = request.getParameter("shipping");
        String total = request.getParameter("total");

        // Tạo đối tượng
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setFirstName(firstName);
        orderDetail.setLastName(lastName);
        orderDetail.setCompanyName(companyName);
        orderDetail.setCountryName(countryName);
        orderDetail.setStreetAddress(streetAddress);
        orderDetail.setPostCode(postCode);
        orderDetail.setCityName(cityName);
        orderDetail.setEmailAddress(emailAddress);
        orderDetail.setPhoneNumber(phoneNumber);

        try {
            // Tính toán và thiết lập tổng số tiền
            double subtotalAmount = parseDoubleOrZero(request.getParameter("subtotal"));
            double shippingAmount = parseDoubleOrZero(request.getParameter("shipping"));
            double totalAmount = parseDoubleOrZero(request.getParameter("total"));
    
            orderDetail.setSubtotalAmount(subtotalAmount);
            orderDetail.setTotalAmount(totalAmount);
            orderDetail.setShipping(shippingAmount);

            // Tạo và gửi yêu cầu thanh toán
            PaypalServices paymentServices = new PaypalServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/view/error.jsp");
        }
    }

    private double parseDoubleOrZero(String value) {
        try {
            return value != null && !value.isEmpty() ? Double.parseDouble(value) : 0.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
