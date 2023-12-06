package com.controller;

import com.data.CartDB;
import com.data.ProductDB;
import com.model.Cart;
import com.model.LineItem;
import com.model.Product;
import com.model.User;
import java.io.IOException;

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
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                Product product = ProductDB.findProductById(productId);
                if (product != null) {
                    LineItem newItem = new LineItem(product, quantity);
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
                cart.removeItem(productId.toString());
                CartDB.update(cart);
                break;
            case "empty":
                cart.removeAll();
                CartDB.update(cart);
                break;
            default:
                break;
        }

        response.sendRedirect("view/shopping-cart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/view/shopping-cart.jsp";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDB.findCartByUser(user);

        request.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
