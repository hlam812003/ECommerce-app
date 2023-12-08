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
public class ShopServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Product product = new Product();

        // product.setName("ESSENTIALS SINGLE JERSEY BIG LOGO TEE");
        // product.setDescription(
        // "Whether you're throwing it on after the gym or getting ready to start the
        // day, this adidas staple tee is calling your name. ");
        // product.setType("T-Shirts");
        // product.setPrice(Double.valueOf(15));
        // product.setSize("M");
        // product.setColor("Black");
        // product.setMaterial("Cotton");
        // product.setBrand("adidas");
        // product.setCategory("Clothing");
        // product.setTags("Men, Essentials");
        // product.setImageUrl(
        // "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/39931d57eb8b46309362af0900e970c5_9366/Essentials_Single_Jersey_Big_Logo_Tee_Black_IC9347_21_model.jpg");
        // product.setReleaseDate(LocalDate.now());

        // ProductDB.insert(product);

        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String tags = request.getParameter("tags");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");

        List<Product> products;

        // Nếu có ít nhất một tham số lọc, lọc sản phẩm
        if (category != null || brand != null || color != null || size != null || tags != null || minPrice != null
                || maxPrice != null) {
            products = ProductDB.getFilteredProducts(category, brand, color, size, tags, minPrice, maxPrice);
        } else {
            products = ProductDB.getAllProducts();
        }

        // Gán danh sách sản phẩm và tổng số lượng sản phẩm vào request
        request.setAttribute("products", products);
        request.setAttribute("totalProductCount", products.size());

        String url = "/view/shop.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
