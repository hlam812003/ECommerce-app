package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if (LoginServlet.isLoggedIn(request, response)) {
        //     HttpSession session = request.getSession();
        //     User user = (User) session.getAttribute("user");

        //     Favorites favorites = FavoriteDB.findByUser(user);
        //     if (favorites == null) {
        //         favorites = new Favorites();
        //         FavoriteDB.insert(favorites);
        //     }

        //     String action = request.getParameter("action");
        //     switch (action) {
        //         case "add":

        //             break;

        //         case "remove":
        //             break;
        //         default:
        //             break;

        //     }
        //     request.setAttribute("favorites", favorites);
        // } else {
        //     response.sendRedirect(request.getContextPath() + "/login");
        // }

        // Long productId = Long.parseLong(request.getParameter("productId"));

        // Favorites favorites = FavoriteDB.findByUser(user);
        // if (favorites == null) {
        //     favorites = new Favorites(user, new ArrayList<>());
        // }

        // if ("add".equals(action)) {
        //     // Thêm sản phẩm vào danh sách yêu thích
        //     Product product = ProductDB.findProductById(productId);
        //     if (product != null) {
        //         favorites.addProduct(product);
        //         FavoriteDB.update(favorites);
        //     }
        // } else if ("remove".equals(action)) {
        //     // Xóa sản phẩm khỏi danh sách yêu thích
        //     favorites.removeProduct(productId);
        //     FavoriteDB.update(favorites);
        // }

        // response.sendRedirect("favorites.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
