<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="description" content="Fashi Ecommerce">
                <meta name="keywords" content="Fashi, unica, creative, html">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">
                <title>Fashi | Contact</title>

                <!-- Google Font -->
                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet">

                <!-- Css Styles -->
                <link rel="stylesheet" href="../assets/css/bootstrap.min.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/font-awesome.min.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/themify-icons.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/elegant-icons.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/owl.carousel.min.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/nice-select.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/jquery-ui.min.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/slicknav.min.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/style.css" type="text/css">
            </head>

            <body>
                <!-- Page preloader -->
                <div id="preloader">
                    <div class="loader"></div>
                </div>

                <!-- Header Section Begin -->
                <header class="header-section">
                    <div class="header-top">
                        <div class="container">
                            <div class="ht-left">
                                <div class="mail-service">
                                    <i class=" fa fa-envelope"></i>
                                    group1.dev@gmail.com
                                </div>
                                <div class="phone-service">
                                    <i class=" fa fa-phone"></i>
                                    +84 90.188.888
                                </div>
                            </div>
                            <div class="ht-right">
                                  <c:choose>
                                    <c:when test="${cookie.email.value != null}">
                                        <div class="login__sec">
                                            <a href="#" class="login-panel">Welcome back,
                                                <strong>
                                                    <c:out value='${fn:split(cookie.email.value, "@")[0]}' />
                                                </strong>
                                            </a>
                                            <div class="cart-hover">
                                                <div class="select-button">
                                                    <a href="/profile" class="primary-btn account-detail"
                                                        style="margin-bottom: 16px;">YOUR PROFILE</a>
                                                    <a href="/logout" class="primary-btn log-out">LOG OUT</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/login" class="login-panel"><i class="fa fa-user"></i>Login</a>
                                    </c:otherwise>
                                </c:choose>
                                <!-- <div class="lan-selector">
                        <select class="language_drop" name="countries" id="countries" style="width:300px;">
                            <option value='yt' data-image="./public/img/flag-1.jpg" data-imagecss="flag yt"
                                data-title="English">English</option>
                            <option value='yu' data-image="./public/img/flag-2.jpg" data-imagecss="flag yu"
                                data-title="Bangladesh">German </option>
                        </select>
                    </div> -->
                                <div class="top-social">
                                    <a href="#"><i class="ti-facebook"></i></a>
                                    <a href="#"><i class="ti-twitter-alt"></i></a>
                                    <a href="#"><i class="ti-linkedin"></i></a>
                                    <a href="#"><i class="ti-pinterest"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="inner-header">
                            <div class="row">
                                <div class="col-lg-2 col-md-2">
                                    <div class="logo">
                                        <a href="/">
                                            <img src="../public/img/logo.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-7 col-md-7">
                                    <div class="advanced-search">
                                        <button type="button" class="category-btn">All Categories</button>
                                        <form action="search" method="GET">
                                            <div class="input-group">
                                                <input type="text" name="query" placeholder="What do you need?" required />
                                                <button type="submit"><i class="ti-search"></i></button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-3 text-right col-md-3">
                                    <ul class="nav-right">
                                        <li class="heart-icon">
                                            <a href="#">
                                                <i class="icon_heart_alt"></i>
                                                <!-- <span>1</span> -->
                                            </a>
                                            <div class="cart-hover">
                                                <div class="select-items">
                                                    <table>
                                                        <tbody>
                                                            <c:forEach items="${favorites.products}" var="product">
                                                                <tr>
                                                                    <td class="si-pic">
                                                                        <c:if test="${not empty product.imageUrl}">
                                                                            <img src="${product.imageUrl}"
                                                                                alt="${product.name}" />
                                                                        </c:if>
                                                                    </td>
                                                                    <td class="si-text">
                                                                        <div class="product-selected">
                                                                            <p>$${product.price}</p>
                                                                            <h6>${product.name}</h6>
                                                                        </div>
                                                                    </td>
                                                                    <td class="si-close">
                                                                        <i class="ti-close"></i>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="cart-icon">
                                            <a href="/shopping-cart">
                                                <i class="icon_bag_alt"></i>
                                                <span>${cartQuantity}</span>
                                            </a>
                                            <div class="cart-hover">
                                                <div class="select-items">
                                                    <table>
                                                        <tbody>
                                                            <c:choose>
                                                                <c:when test="${empty cart.items}">
                                                                    <tr>
                                                                        <td class="text-center" style="font-weight: bold;">Your cart is empty. Buy some?</td>
                                                                    </tr>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:forEach items="${cart.items}" var="item">
                                                                        <tr>
                                                                            <td class="si-pic">
                                                                                <c:if test="${not empty item.item.imageUrl}">
                                                                                    <img src="${item.item.imageUrl}"
                                                                                        alt="${item.item.name}" />
                                                                                </c:if>
                                                                            </td>
                                                                            <td class="si-text">
                                                                                <div class="product-selected">
                                                                                    <p>
                                                                                        $${item.item.price} x ${item.quantity}
                                                                                    </p>
                                                                                    <h6>${item.item.name}</h6>
                                                                                </div>
                                                                            </td>
                                                                            <td class="si-close">
                                                                                <a href="/shop/removeFromCart?id=${item.item.productId}"
                                                                                    class="ti-close"></a>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="select-total">
                                                    <span>subtotal:</span>
                                                    <h5>$${cartTotal}</h5>
                                                </div>
                                                <div class="select-button">
                                                    <a href="/shopping-cart" class="primary-btn view-cart">VIEW CART</a>
                                                    <a href="/checkout" class="primary-btn checkout-btn">CHECKOUT</a>
                                                </div>
                                            </div>
                                        </li>
                                       <li class="cart-price">$${cartTotal}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nav-item">
                        <div class="container">

                            <nav class="nav-menu mobile-menu"
                                style="display: flex; justify-content: center; align-items: center;">
                                <ul>
                                    <li><a href="/">Home</a></li>
                                    <li><a href="/shop">Shop</a></li>
                                    <li><a href="#">Collection</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Men's</a></li>
                                            <li><a href="#">Women's</a></li>
                                            <li><a href="#">Kid's</a></li>
                                        </ul>
                                    </li>
                                    <!-- <li><a href="./blog.html">Blog</a></li> -->
                                    <li class="active"><a href="/contact">Contact</a></li>
                                    <!-- <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                <li><a href="./check-out.html">Checkout</a></li>
                                <li><a href="./faq.html">Faq</a></li>
                                <li><a href="./register.html">Register</a></li>
                                <li><a href="./login.html">Login</a></li>
                            </ul>
                        </li> -->
                                </ul>
                            </nav>
                            <div id="mobile-menu-wrap"></div>
                        </div>
                    </div>
                </header>
                <!-- Header End -->

                <!-- Breadcrumb Section Begin -->
                <div class="breadcrumb-section">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="breadcrumb-text">
                                    <a href="/"><i class="fa fa-home"></i> Home</a>
                                    <span>Contact</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb Section Begin -->

                <!-- Map Section Begin -->
                <div class="map spad">
                    <div class="container">
                        <div class="map-inner">
                            <iframe
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.4853986111016!2d106.76933817506156!3d10.850637657820473!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752763f23816ab%3A0x282f711441b6916f!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBTxrAgcGjhuqFtIEvhu7kgdGh14bqtdCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1699598550697!5m2!1svi!2s"
                                height="610" style="border:0" allowfullscreen="">
                            </iframe>
                            <div class="icon">
                                <i class="fa fa-map-marker"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Map Section Begin -->

                <!-- Contact Section Begin -->
                <section class="contact-section spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="contact-title">
                                    <h4>Contacts Us</h4>
                                    <p>Contrary to popular belief, Lorem Ipsum is simply random text. It has roots in a
                                        piece of
                                        classical Latin literature from 45 BC, maki years old.</p>
                                </div>
                                <div class="contact-widget">
                                    <div class="cw-item">
                                        <div class="ci-icon">
                                            <i class="ti-location-pin"></i>
                                        </div>
                                        <div class="ci-text">
                                            <span>Address:</span>
                                            <p>1 Vo Van Ngan Street</p>
                                        </div>
                                    </div>
                                    <div class="cw-item">
                                        <div class="ci-icon">
                                            <i class="ti-mobile"></i>
                                        </div>
                                        <div class="ci-text">
                                            <span>Phone:</span>
                                            <p>+84 90.188.888</p>
                                        </div>
                                    </div>
                                    <div class="cw-item">
                                        <div class="ci-icon">
                                            <i class="ti-email"></i>
                                        </div>
                                        <div class="ci-text">
                                            <span>Email:</span>
                                            <p>group1.dev@gmail.com</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 offset-lg-1">
                                <div class="contact-form">
                                    <div class="leave-comment">
                                        <h4>Leave A Comment</h4>
                                        <p>Our staff will call back later and answer your questions.</p>
                                        <form action="#" class="comment-form">
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <input type="text" placeholder="Your name">
                                                </div>
                                                <div class="col-lg-6">
                                                    <input type="text" placeholder="Your email">
                                                </div>
                                                <div class="col-lg-12">
                                                    <textarea placeholder="Your message"></textarea>
                                                    <button type="submit" class="site-btn">Send message</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Contact Section End -->

                <!-- Partner Logo Section Begin -->
                <div class="partner-logo">
                    <div class="container">
                        <div class="logo-carousel owl-carousel">
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-1.png" alt="">
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-2.png" alt="">
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-3.png" alt="">
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-4.png" alt="">
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-5.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Partner Logo Section End -->

                <!-- Footer Section Begin -->
                <footer class="footer-section">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="footer-left">
                                    <div class="footer-logo">
                                        <a href="#"><img src="../public/img/footer-logo.png" alt=""></a>
                                    </div>
                                    <ul>
                                        <li>Address: 1 Vo Van Ngan Street</li>
                                        <li>Phone: +84 90.188.888</li>
                                        <li>Email: group1.dev@gmail.com</li>
                                    </ul>
                                    <div class="footer-social">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-instagram"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-pinterest"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 offset-lg-1">
                                <div class="footer-widget">
                                    <h5>Information</h5>
                                    <ul>
                                        <li><a href="#">About Us</a></li>
                                        <li><a href="#">Checkout</a></li>
                                        <li><a href="#">Contact</a></li>
                                        <li><a href="#">Serivius</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="footer-widget">
                                    <h5>My Account</h5>
                                    <ul>
                                        <li><a href="#">My Account</a></li>
                                        <li><a href="#">Contact</a></li>
                                        <li><a href="#">Shopping Cart</a></li>
                                        <li><a href="#">Shop</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="newslatter-item">
                                    <h5>Join Our Newsletter Now</h5>
                                    <p>Get E-mail updates about our latest shop and special offers.</p>
                                    <form action="#" class="subscribe-form">
                                        <input type="text" placeholder="Enter Your Mail">
                                        <button type="button">Subscribe</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </footer>
                <!-- Footer Section End -->

                <!-- Js Plugins -->
                <script src="../assets/js/jquery-3.3.1.min.js"></script>
                <script src="../assets/js/bootstrap.min.js"></script>
                <script src="../assets/js/jquery-ui.min.js"></script>
                <script src="../assets/js/jquery.countdown.min.js"></script>
                <script src="../assets/js/jquery.nice-select.min.js"></script>
                <script src="../assets/js/jquery.zoom.min.js"></script>
                <script src="../assets/js/jquery.dd.min.js"></script>
                <script src="../assets/js/jquery.slicknav.js"></script>
                <script src="../assets/js/owl.carousel.min.js"></script>
                <script src="../assets/js/main.js"></script>
            </body>

            </html>