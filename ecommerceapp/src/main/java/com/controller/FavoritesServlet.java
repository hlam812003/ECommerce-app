package com.controller;

import java.io.IOException;

import com.data.FavoriteDB;
import com.data.ProductDB;
import com.model.Favorites;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            Long productId = Long.parseLong(request.getParameter("id"));

            System.out.println(action + productId);

            HttpSession session = request.getSession();
            Favorites favorites = (Favorites) session.getAttribute("favorites");
            if (favorites != null) {
                if (action.equals("add")) {
                    favorites.addProduct(ProductDB.findProductById(productId));
                    System.out.println("ADD");
                } else if (action.equals("remove")) {
                    favorites.removeProduct(productId);
                    System.out.println("REMOVE");
                }
                FavoriteDB.update(favorites);
                String referer = request.getHeader("referer");
                if (referer != null)
                    response.sendRedirect(referer);
                else
                    response.sendRedirect(request.getContextPath() + "/");
                return;
            } else
                response.sendRedirect(request.getContextPath() + "/login");
            return;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // }

}
