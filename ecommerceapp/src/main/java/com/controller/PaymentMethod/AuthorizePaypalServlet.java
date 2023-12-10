package com.controller.PaymentMethod;

import java.io.IOException;

import com.model.OrderDetail;
import com.payment.paypal.PaypalServices;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            // Kiểm tra và chuyển đổi giá trị số tiền
            double subtotalAmount = (subtotal != null && !subtotal.trim().isEmpty()) ? Double.parseDouble(subtotal) : 0.0;
            double shippingAmount = (shipping != null && !shipping.trim().isEmpty()) ? Double.parseDouble(shipping) : 0.0;
            double totalAmount = (total != null && !total.trim().isEmpty()) ? Double.parseDouble(total) : 0.0;

            // Kiểm tra nếu tổng số tiền là 0, thì thông báo lỗi
            if (totalAmount <= 0) {
                request.setAttribute("errorMessage", "Total amount cannot be zero.");
                response.sendRedirect(request.getContextPath() + "/view/error.jsp");
                return;
            }

            orderDetail.setSubtotalAmount(subtotalAmount);
            orderDetail.setTotalAmount(totalAmount);
            orderDetail.setTaxRate(shippingAmount);

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

    // private double parseDoubleOrZero(String value) {
    //     try {
    //         return value != null && !value.isEmpty() ? Double.parseDouble(value) : 0.0;
    //     } catch (NumberFormatException e) {
    //         return 0.0;
    //     }
    // }
}
