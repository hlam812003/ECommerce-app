package com.controller;

import java.io.IOException;
import java.util.List;

import com.data.CartDB;
import com.data.LineItemDB;
import com.model.Cart;
import com.model.LineItem;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shop/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
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
            System.out.println(request.getParameter("id"));
            Long productId = Long.parseLong(request.getParameter("id"));

            Cart cart = (Cart) CartDB.findCartByUser(user);
            if (cart != null) {
                List<LineItem> lineItems = cart.getItems();

                for (LineItem item : lineItems) {
                    if (item.getItem().getProductId().equals(productId)) {
                        cart.removeItem(productId);
                        CartDB.update(cart);
                        LineItemDB.delete(item);
                        break;
                    }
                }
            }

            String referer = request.getHeader("referer");

            if (referer != null)
                response.sendRedirect(referer);
            else
                response.sendRedirect(request.getContextPath() + "/");

            return;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
    }
}
