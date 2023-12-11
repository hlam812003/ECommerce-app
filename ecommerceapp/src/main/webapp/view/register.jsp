<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8" />
                <meta name="description" content="Fashi Ecommerce" />
                <meta name="keywords" content="Fashi, unica, creative, html" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <meta http-equiv="X-UA-Compatible" content="ie=edge" />
                <title>Fashi | Register</title>

                <!-- Google Font -->
                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet" />

                <!-- Css Styles -->
                <link rel="stylesheet" href="../assets/css/bootstrap.min.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/font-awesome.min.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/themify-icons.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/elegant-icons.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/owl.carousel.min.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/nice-select.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/jquery-ui.min.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/slicknav.min.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/toast.css" type="text/css" />
                <link rel="stylesheet" href="../assets/css/style.css" type="text/css" />
            </head>

            <body>
                <!-- Page Preloader -->
                <div id="preloader">
                    <div class="loader"></div>
                </div>

                <!-- Header Section Begin -->
                <header class="header-section">
                    <%@ include file="../includes/header.jsp" %>
                    <div class="nav-item">
                        <div class="container">
                            <nav class="nav-menu mobile-menu"
                                style="display: flex; justify-content: center; align-items: center">
                                <ul>
                                    <li><a href="/">Home</a></li>
                                    <li><a href="/shop">Shop</a></li>
                                    <li>
                                        <a href="/collection">Collection</a>
                                        <ul class="dropdown">
                                            <li><a href="/collection/men">Men's</a></li>
                                            <li><a href="/collection/women">Women's</a></li>
                                            <li><a href="/collection/kid">Kid's</a></li>
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
                                <div class="breadcrumb-text">
                                    <a href="/"><i class="fa fa-home"></i> Home</a>
                                    <span>Register</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb Form Section Begin -->

                <!-- Register Section Begin -->
                <div class="register-login-section spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 offset-lg-3">
								<div class="register-form">
									<h2>Register</h2>
									<form action="register" method="post">
										<input type="hidden" name="action" value="register" />
										<div class="group-input">
											<label for="email">Email address *</label>
											<input type="email" name="email" required autocomplete="off" />
										</div>
										<div class="group-input">
											<label for="password">Password *</label>
											<input type="password" name="password" required autocomplete="off" />
										</div>
										<div class="group-input">
											<label for="confirm-password">Confirm Password *</label>
											<input type="password" name="confirm-password" required autocomplete="off" />
										</div>
										<button type="submit" class="site-btn register-btn">REGISTER</button>
									</form>
									<c:if test="${not empty message}">
										<p class="message"><i>${message}</i></p>
									</c:if>
									<div class="switch-login">
										<a href="/login" class="or-login">Or Login</a>
									</div>
								</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Register Form Section End -->

                <!-- Partner Logo Section Begin -->
                <div class="partner-logo">
                    <div class="container">
                        <div class="logo-carousel owl-carousel">
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-1.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-2.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-3.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-4.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="../public/img/logo-carousel/logo-5.png" alt="" />
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
                                        <a href=""><img src="../public/img/footer-logo.png" alt="" /></a>
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
                                        <input type="text" placeholder="Enter Your Mail" />
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
                <script type="module">
                    import Toast from '../assets/js/Toast/Toast.js';

                    const displayToast = (message, title, type) => {
                        new Toast({
                            autoClose: 5000,
                            canCloseOnClick: true,
                            darkMode: false,
                            onClose: () => { },
                            position: "top-center",
                            pauseOnHover: true,
                            pauseOnFocusLoss: true,
                            playNotificationSound: false,
                            showProgressBar: true,
                            toastContent: {
                                message,
                                title,
                                type
                            },
                        });
                    };

                    document.addEventListener('DOMContentLoaded', () => {
                        const registrationError = '${requestScope.message}';

                        if (registrationError) {
                            displayToast(registrationError, "Registration failed!", "error");
                        }

                        const form = document.querySelector('.register-form form');
                        form.addEventListener('submit', (e) => {
                            const email = document.querySelector('input[name="email"]').value.trim();
                            const password = document.querySelector('input[name="password"]').value.trim();
                            const confirmPassword = document.querySelector('input[name="confirm-password"]').value.trim();

                            if (!email || !password || !confirmPassword) {
                                e.preventDefault();
                                displayToast("Please enter your login information!", "Information is empty!", "warning");
                            } else if (password !== confirmPassword) {
                                e.preventDefault();
                                displayToast("Password and confirm password do not match.", "Password incorrect!", "error");
                            }
                        });
                    });
                </script>
            </body>

            </html>