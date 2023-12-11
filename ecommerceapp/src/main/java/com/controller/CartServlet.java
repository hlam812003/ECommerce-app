package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

@WebServlet("/shopping-cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        final Object lock = session.getId().intern();

        synchronized(lock) {
            switch (action) {
                case "update-quantity":
                    Map<String, String[]> parameterMap = request.getParameterMap();

                    for (String key : parameterMap.keySet()) {
                        if (key.equals("quantity")) {
                            User user = (User) session.getAttribute("user");
                            Cart cart = (Cart) CartDB.findCartByUser(user);
                            List<LineItem> lineItems = cart.getItems();

                            int index = 0;
                            String[] quantityList = (String[]) parameterMap.get(key);
                            for (String quantity : quantityList) {
                                LineItem item = lineItems.get(index++);
                                item.setQuantity(Integer.parseInt(quantity));
                                LineItemDB.update(item);
                            }
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        response.sendRedirect(request.getContextPath() + "/shopping-cart");
        return;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            ShopServlet.setCart(request, response);

            String url = "/view/shopping-cart.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
    }
}
