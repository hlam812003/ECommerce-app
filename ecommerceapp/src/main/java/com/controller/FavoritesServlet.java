package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.data.FavoriteDB;
import com.data.ProductDB;
import com.model.Favorites;
import com.model.Product;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            // Người dùng chưa đăng nhập
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        Long productId = Long.parseLong(request.getParameter("productId"));

        Favorites favorites = FavoriteDB.findByUser(user);
        if (favorites == null) {
            favorites = new Favorites(user, new ArrayList<>());
        }

            
        if ("add".equals(action)) {
            // Thêm sản phẩm vào danh sách yêu thích
            Product product = ProductDB.findProductById(productId);
            if (product != null) {
                favorites.addProduct(product);
                FavoriteDB.update(favorites);
            }
        } else if ("remove".equals(action)) {
            // Xóa sản phẩm khỏi danh sách yêu thích
            favorites.removeProduct(productId.toString());
            FavoriteDB.update(favorites);
        }

        // response.sendRedirect("favorites.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            // Người dùng chưa đăng nhập
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Favorites favorites = FavoriteDB.findByUser(user);
        if (favorites == null) {
            favorites = new Favorites(user, new ArrayList<>());
        }

        request.setAttribute("favorites", favorites);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("favorites.jsp");
        // dispatcher.forward(request, response);
    }

}
