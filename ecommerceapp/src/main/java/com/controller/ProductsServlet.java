package com.controller;

import java.io.IOException;
import java.util.List;

import com.data.ProductDB;
import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class ProductsServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                List<Product> productList = ProductDB.getAllProducts();
                request.setAttribute("products", productList);

                String url = "/view/shop.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
        }

}
