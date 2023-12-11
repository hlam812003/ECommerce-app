package com.controller;

import java.io.IOException;
import java.util.List;

import com.data.CartDB;
import com.data.LineItemDB;
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
            final Object lock = session.getId().intern();

            synchronized(lock) {
                User user = (User) session.getAttribute("user");
                Long productId = Long.parseLong(request.getParameter("id"));

                Cart cart = CartDB.findCartByUser(user);
                if (cart == null) {
                    Product product = ProductDB.findProductById(productId);
                    int quantity = 1;
                    LineItem item = new LineItem();
                    item.setItem(product);
                    item.setQuantity(quantity);
                    cart = new Cart(user, item);

                    LineItemDB.insert(item);

                    CartDB.insert(cart);
                } else {
                    boolean added = false;

                    List<LineItem> lineItems = cart.getItems();
                    for (LineItem item : lineItems) {
                        if (item.getItem().getProductId().equals(productId)) {
                            item.setQuantity(item.getQuantity() + 1);
                            LineItemDB.update(item);
                            added = true;
                            break;
                        }
                    }

                    if (!added) {
                        Product product = ProductDB.findProductById(productId);
                        int quantity = 1;
                        LineItem item = new LineItem(null, product, quantity);

                        LineItemDB.insert(item);
                        cart.addItem(item);
                    }

                    CartDB.update(cart);
                }

                ShopServlet.setCart(request, response);

                String currentPage = request.getParameter("currentPage");
                response.sendRedirect(currentPage != null ? currentPage : request.getContextPath() + "/shop");
            }                
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        
    }
}
