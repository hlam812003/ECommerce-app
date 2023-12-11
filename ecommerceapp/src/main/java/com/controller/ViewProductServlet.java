package com.controller;

import java.io.IOException;
import com.model.Product;
import com.data.ProductDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shop/viewProduct")
public class ViewProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralServlet.isLoaded(request, response);

        String productIdParam = request.getParameter("id");
        if (productIdParam != null) {
            try {
                Long productId = Long.parseLong(productIdParam);
                Product product = ProductDB.findProductById(productId);
                if (product != null) {
                    request.setAttribute("product", product);

                    ShopServlet.setCart(request, response);

                    getServletContext().getRequestDispatcher("/view/product.jsp").forward(request, response);
                } else {
                    // Xử lý trường hợp không tìm thấy sản phẩm
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                }
            } catch (NumberFormatException e) {
                // Xử lý trường hợp ID sản phẩm không hợp lệ
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
            }
        } else {
            // Xử lý trường hợp không có ID sản phẩm
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product ID");
        }
    }
}