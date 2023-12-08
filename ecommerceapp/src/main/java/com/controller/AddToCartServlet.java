package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.data.CartDB;
import com.data.ProductDB;
import com.model.Cart;
import com.model.LineItem;
import com.model.Product;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shop/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Long productId = Long.parseLong(request.getParameter("id"));

            Cart cart = CartDB.findCartByUser(user);
            if (cart == null) {
                cart = new Cart(user);
                CartDB.insert(cart);
            }

            List<LineItem> lineItems = cart.getItems();
            if (lineItems == null) {
                lineItems = new ArrayList<LineItem>();
            }

            boolean added = false;

            for (int i = 0; i < lineItems.size(); i++) {
                LineItem item = lineItems.get(i);
                if (item.getItem().getProductId() == productId) {
                    int quantity = item.getQuantity();
                    item.setQuantity(quantity + 1);
                    added = true;
                }
            }
            if (!added) {
                Product product = ProductDB.findProductById(productId);
                int quantity = 1;
                LineItem item = new LineItem(product, quantity);
                cart.addItem(item);
            }
            cart.setItems(lineItems);
            CartDB.update(cart);

            request.setAttribute("cart", cart);

            response.sendRedirect(request.getContextPath() + "/shop");
        }
    }
}
