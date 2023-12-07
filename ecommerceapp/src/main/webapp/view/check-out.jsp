<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="description" content="Fashi Template">
                <meta name="keywords" content="Fashi, unica, creative, html">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">
                <title>Fashi | Template</title>

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
                                        <a href="/profile" class="login-panel">Welcome back,
                                            <strong>
                                                <c:out value='${fn:split(cookie.email.value, "@")[0]}' />
                                            </strong>
                                        </a>
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
                                        <form action="#" class="input-group">
                                            <input type="text" placeholder="What do you need?">
                                            <button type="button"><i class="ti-search"></i></button>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-3 text-right col-md-3">
                                    <ul class="nav-right">
                                        <li class="heart-icon"><a href="#">
                                                <i class="icon_heart_alt"></i>
                                                <!-- <span>1</span> -->
                                            </a>
                                        </li>
                                        <li class="cart-icon"><a href="#">
                                                <i class="icon_bag_alt"></i>
                                                <!-- <span>3</span> -->
                                            </a>
                                            <div class="cart-hover">
                                                <div class="select-items">
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                                <td class="si-pic"><img
                                                                        src="../public/img/select-product-1.jpg" alt="">
                                                                </td>
                                                                <td class="si-text">
                                                                    <div class="product-selected">
                                                                        <p>$60.00 x 1</p>
                                                                        <h6>Kabino Bedside Table</h6>
                                                                    </div>
                                                                </td>
                                                                <td class="si-close">
                                                                    <i class="ti-close"></i>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="si-pic"><img
                                                                        src="../public/img/select-product-2.jpg" alt="">
                                                                </td>
                                                                <td class="si-text">
                                                                    <div class="product-selected">
                                                                        <p>$60.00 x 1</p>
                                                                        <h6>Kabino Bedside Table</h6>
                                                                    </div>
                                                                </td>
                                                                <td class="si-close">
                                                                    <i class="ti-close"></i>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="select-total">
                                                    <span>total:</span>
                                                    <h5>$120.00</h5>
                                                </div>
                                                <div class="select-button">
                                                    <a href="#" class="primary-btn view-cart">VIEW CART</a>
                                                    <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="cart-price">$0</li>
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
                                    <li><a href="/contact">Contact</a></li>
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
                                <div class="breadcrumb-text product-more">
                                    <a href="/"><i class="fa fa-home"></i> Home</a>
                                    <a href="/shop">Shop</a>
                                    <span>Check Out</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb Section Begin -->

                <!-- Shopping Cart Section Begin -->
                <section class="checkout-section spad">
                    <div class="container">
                        <form id="checkoutForm" method="post" class="checkout-form" onsubmit="handleFormSubmit()">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout-content">
                                        <a href="/" class="content-btn">Click Here To Login</a>
                                    </div>
                                    <h4>Biiling Details</h4>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <label for="fir">First Name<span>*</span></label>
                                            <input type="text" id="fir" name="firstName" required>
                                        </div>
                                        <div class="col-lg-6">
                                            <label for="last">Last Name<span>*</span></label>
                                            <input type="text" id="last" name="lastName" required>
                                        </div>
                                        <div class="col-lg-12">
                                            <label for="cun-name">Company Name</label>
                                            <input type="text" id="cun-name" name="companyName" required>
                                        </div>
                                        <div class="col-lg-12">
                                            <label for="cun">Country<span>*</span></label>
                                            <input type="text" id="cun" name="countryName" required>
                                        </div>
                                        <div class="col-lg-12">
                                            <label for="street">Street Address<span>*</span></label>
                                            <input type="text" id="street" class="street-first" name="streetAddress"
                                                required>
                                            <!-- <input type="text"> -->
                                        </div>
                                        <div class="col-lg-12">
                                            <label for="zip">Postcode / ZIP (optional)</label>
                                            <input type="text" id="zip" name="postCode" required>
                                        </div>
                                        <div class="col-lg-12">
                                            <label for="town">Town / City<span>*</span></label>
                                            <input type="text" id="town" name="cityName" required>
                                        </div>
                                        <div class="col-lg-6">
                                            <label for="email">Email Address<span>*</span></label>
                                            <input type="text" id="email" name="emailAddress" required>
                                        </div>
                                        <div class="col-lg-6">
                                            <label for="phone">Phone<span>*</span></label>
                                            <input type="text" id="phone" name="phoneNumber" required>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="create-item">
                                                <label for="acc-create">
                                                    Create an account?
                                                    <input type="checkbox" id="acc-create">
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout-content">
                                        <input type="text" placeholder="Enter Your Coupon Code">
                                    </div>
                                    <div class="place-order">
                                        <h4>Your Order</h4>
                                        <div class="order-total">
                                            <ul class="order-table">
                                                <li>Product <span>Total</span></li>
                                                <c:forEach items="${cart.items}" var="item">
                                                    <li class="fw-normal">${item.item.name} x ${item.quantity}
                                                        <span>$${item.totalPrice}</span></li>
                                                </c:forEach>
                                                <li class="fw-normal">Subtotal <span>$${cartTotal}</span></li>
                                                <li class="fw-normal">Shipping <span>$${shippingFee}</span></li>
                                                <li class="total-price">Total <span>$${cartTotal + shippingFee}</span>
                                                </li>
                                            </ul>
                                            <div class="payment-check">
                                                <div class="pc-item">
                                                    <label for="pc-check">Cheque Payment
                                                        <input type="radio" id="pc-check" name="paymentMethod"
                                                            value="cheque" checked>
                                                        <span class="checkmark"></span>
                                                    </label>
                                                </div>
                                                <div class="pc-item">
                                                    <label for="pc-paypal">Paypal
                                                        <input type="radio" id="pc-paypal" name="paymentMethod"
                                                            value="paypal">
                                                        <span class="checkmark"></span>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="order-btn">
                                                <button type="submit" class="site-btn place-btn">Place Order</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
                <!-- Shopping Cart Section End -->

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
                                        <li>Address: 60-49 Road 11378 New York</li>
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
                <script type="text/javascript">
                    function handleFormSubmit() {
                        var form = document.getElementById('checkoutForm');
                        var paymentMethod = document.querySelector('input[name="paymentMethod"]:checked').value;
                        form.action = paymentMethod === 'paypal' ? 'paypal-authorize' : 'checkout';
                    }
                </script>
            </body>

            </html>