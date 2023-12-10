package com.controller;

import java.io.IOException;

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

@WebServlet("/shopping-cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDB.findCartByUser(user);

        switch (action) {
            case "add":
                Long productId = Long.parseLong(request.getParameter("productId"));
                Product product = ProductDB.findProductById(productId);
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                if (product != null) {
                    LineItem newItem = new LineItem();
                    newItem.setItem(product);
                    newItem.setQuantity(quantity);
                    cart.addItem(newItem);
                    CartDB.update(cart);
                }
                break;
            case "update":
                productId = Long.parseLong(request.getParameter("productId"));
                quantity = Integer.parseInt(request.getParameter("quantity"));
                cart.getItems().forEach(item -> {
                    if (item.getItem().getProductId().equals(productId)) {
                        item.setQuantity(quantity);
                    }
                });
                CartDB.update(cart);
                break;
            case "remove":
                productId = Long.parseLong(request.getParameter("productId"));
                cart.removeItem(productId);
                CartDB.update(cart);
                break;
            case "empty":
                cart.removeAll();
                CartDB.update(cart);
                break;
            default:
                break;
        }

        response.sendRedirect(request.getContextPath() + "/view/shopping-cart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDB.findCartByUser(user);

        if (cart != null) {
            double total = cart.getTotalPrice();
            request.setAttribute("cartTotal", total);
        }

        request.setAttribute("cart", cart);
        String url = "/view/shopping-cart.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
