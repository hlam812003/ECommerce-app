package com.controller;

import java.io.IOException;

import com.cookie.CookieUtil;
import com.data.CartDB;
import com.data.FavoriteDB;
import com.data.UserDB;
import com.model.Cart;
import com.model.Favorites;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GeneralServlet {
    public static boolean isLoaded(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {

            Cookie[] cookies = request.getCookies();
            String email = CookieUtil.getCookieValue(cookies, "email");

            if (email == null || email.isEmpty()) {
                return false;
            } else {
                user = UserDB.selectUser(email);
                if (user != null && user.isVerified()) {
                    session.setAttribute("user", user);
                } else {
                    return false;
                }
            }
        }
        request.setAttribute("user", user);

        Cart cart = CartDB.findCartByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            CartDB.insert(cart);
        }

        session.setAttribute("cart", cart);
        request.setAttribute("cart", cart);
        request.setAttribute("cartQuantity", cart.getQuantity());
        request.setAttribute("cartTotal", cart.getTotal());

        Favorites favorites = FavoriteDB.findByUser(user);
        if (favorites == null) {
            favorites = new Favorites();
            favorites.setUser(user);
            FavoriteDB.insert(favorites);
        }

        session.setAttribute("favorites", favorites);
        request.setAttribute("favorites", favorites);
        request.setAttribute("favoritesQuantity", favorites.getProducts().size());

        return true;
    }
}
