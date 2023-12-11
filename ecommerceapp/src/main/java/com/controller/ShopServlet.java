package com.controller;

import java.io.IOException;
import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.List;

import com.cookie.CookieUtil;
import com.data.CartDB;
import com.data.ProductDB;
import com.data.UserDB;
import com.model.Cart;
import com.model.Product;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginServlet.isLoggedIn(request, response)) {
            setCart(request, response);
        }

        Product product = new Product();

        product.setName("ESSENTIALS SINGLE JERSEY BIG LOGO TEE");
        product.setDescription(
                "Whether you're throwing it on after the gym or getting ready to start the day, this adidas staple tee is calling your name.");
        product.setType("T-Shirts");
        product.setPrice(Double.valueOf(15));
        product.setSize("M");
        product.setColor("Black");
        product.setMaterial("Cotton");
        product.setBrand("adidas");
        product.setCategory("Clothing");
        product.setTags("Men, Essentials");
        product.setImageUrl(
                "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/39931d57eb8b46309362af0900e970c5_9366/Essentials_Single_Jersey_Big_Logo_Tee_Black_IC9347_21_model.jpg");
        product.setReleaseDate(LocalDate.now());

        // List<String> imageUrls = new ArrayList<>();
        // imageUrls.add("https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/39931d57eb8b46309362af0900e970c5_9366/Essentials_Single_Jersey_Big_Logo_Tee_Black_IC9347_21_model.jpg");
        // imageUrls.add("https://img1.theiconic.com.au/DNFYf2h4sn1bmvz_NcKwmbE65rg=/fit-in/1000x0/filters:fill(ffffff):quality(85):format(webp)/http%3A%2F%2Fstatic.theiconic.com.au%2Fp%2Fadidas-sportswear-9384-8051181-2.jpg");
        // imageUrls.add("https://img1.theiconic.com.au/BoVTfOuXmUl1Oo4HN0bkMt5nIgo=/fit-in/1000x0/filters:fill(ffffff):quality(85):format(webp)/http%3A%2F%2Fstatic.theiconic.com.au%2Fp%2Fadidas-sportswear-9394-8051181-3.jpg");
        // imageUrls.add("https://img1.theiconic.com.au/D5wDkqhb8yso3HM5FCNAA1xfcIw=/fit-in/1000x0/filters:fill(ffffff):quality(85):format(webp)/http%3A%2F%2Fstatic.theiconic.com.au%2Fp%2Fadidas-sportswear-9404-8051181-4.jpg");
        // imageUrls.add("https://img1.theiconic.com.au/oa19E-lHCzIyyYeh5-nnWHMuqpw=/fit-in/1000x0/filters:fill(ffffff):quality(85):format(webp)/http%3A%2F%2Fstatic.theiconic.com.au%2Fp%2Fadidas-sportswear-9414-8051181-5.jpg");
        // imageUrls.add("https://img1.theiconic.com.au/1kCCDLlOLX7kTDFITOQvsdbHxRk=/634x811/filters:quality(95):fill(ffffff)/http%3A%2F%2Fstatic.theiconic.com.au%2Fp%2Fadidas-sportswear-9424-8051181-6.jpg");
        // product.setImageUrls(imageUrls);

        ProductDB.insert(product);

        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String tags = request.getParameter("tags");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");

        List<Product> products;

        if (category != null ||
                brand != null ||
                color != null ||
                size != null ||
                tags != null ||
                minPrice != null ||
                maxPrice != null) {
            products = ProductDB.getFilteredProducts(category, brand, color, size, tags, minPrice, maxPrice);
        } else {
            products = ProductDB.getAllProducts();
        }

        request.setAttribute("products", products);
        request.setAttribute("totalProductCount", products.size());

        String url = "/view/shop.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    public static void setCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String email = CookieUtil.getCookieValue(cookies, "email");
            // if cookie doesn't exist, go to Registration page
            if (email == null || email.isEmpty()) {
                return;
            } else {
                user = UserDB.selectUser(email);
                if (user != null && user.isVerified()) {
                    session.setAttribute("user", user);
                } else {
                    return;
                }
            }
        }
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
    }
}
