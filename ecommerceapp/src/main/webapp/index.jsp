<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8" />
                <meta name="description" content="Fashi Template" />
                <meta name="keywords" content="Fashi, unica, creative, html" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <meta http-equiv="X-UA-Compatible" content="ie=edge" />
                <title>Fashi | Clothes Store</title>

                <!-- Google Font -->
                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet" />

                <!-- CSS Styles -->
                <link rel="stylesheet" href="./assets/css/bootstrap.min.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/font-awesome.min.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/themify-icons.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/elegant-icons.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/owl.carousel.min.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/nice-select.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/jquery-ui.min.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/slicknav.min.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/toast.css" type="text/css" />
                <link rel="stylesheet" href="./assets/css/style.css" type="text/css" />
            </head>

            <body>
                <!-- Page Preloader -->
                <div id="preloader">
                    <div class="loader"></div>
                </div>

                <!-- Header Section Begin -->
                <header class="header-section">
                    <div class="header-top">
                        <div class="container">
                            <div class="ht-left">
                                <div class="mail-service">
                                    <i class="fa fa-envelope"></i>
                                    group1.dev@gmail.com
                                </div>
                                <div class="phone-service">
                                    <i class="fa fa-phone"></i>
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
                                <!-- <div class="top-social">
                                    <a href="#"><i class="ti-facebook"></i></a>
                                    <a href="#"><i class="ti-twitter-alt"></i></a>
                                    <a href="#"><i class="ti-linkedin"></i></a>
                                    <a href="#"><i class="ti-pinterest"></i></a>
                                </div> -->
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="inner-header">
                            <div class="row">
                                <div class="col-lg-2 col-md-2">
                                    <div class="logo">
                                        <a href="/">
                                            <img src="./public/img/logo.png" alt="" />
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-7 col-md-7">
                                    <div class="advanced-search">
                                        <button type="button" class="category-btn">All Categories</button>
                                        <div class="input-group">
                                            <input type="text" placeholder="What do you need?" />
                                            <button type="button"><i class="ti-search"></i></button>
                                        </div>
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
                                                                        <c:if test="${not empty product.imageUrls}">
                                                                            <img src="${product.imageUrls[0]}"
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
                                            <a href="#">
                                                <i class="icon_bag_alt"></i>
                                                <!-- <span>3</span> -->
                                            </a>
                                            <div class="cart-hover">
                                                <div class="select-items">
                                                    <table>
                                                        <tbody>
                                                            <c:forEach items="${cart.items}" var="item">
                                                                <tr>
                                                                    <td class="si-pic">
                                                                        <c:if test="${not empty item.item.imageUrls}">
                                                                            <img src="${item.item.imageUrls[0]}"
                                                                                alt="${item.item.name}" />
                                                                        </c:if>
                                                                    </td>
                                                                    <td class="si-text">
                                                                        <div class="product-selected">
                                                                            <p>$${item.item.price} x ${item.quantity}
                                                                            </p>
                                                                            <h6>${item.item.name}</h6>
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
                                                <div class="select-total">
                                                    <span>total:</span>
                                                    <h5>$${cartTotal}</h5>
                                                </div>
                                                <div class="select-button">
                                                    <a href="/shopping-cart" class="primary-btn view-cart">VIEW CART</a>
                                                    <a href="/checkout" class="primary-btn checkout-btn">CHECK OUT</a>
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
                                style="display: flex; justify-content: center; align-items: center">
                                <ul>
                                    <li class="active"><a href="#">Home</a></li>
                                    <li><a href="/shop">Shop</a></li>
                                    <li>
                                        <a href="#">Collection</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Men's</a></li>
                                            <li><a href="#">Women's</a></li>
                                            <li><a href="#">Kid's</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="/contact">Contact</a></li>
                                </ul>
                            </nav>
                            <div id="mobile-menu-wrap"></div>
                        </div>
                    </div>
                </header>
                <!-- Header End -->

                <!-- Hero Section Begin -->
                <section class="hero-section">
                    <div class="hero-items owl-carousel">
                        <div class="single-hero-items set-bg" data-setbg="./public/img/hero-1.jpg">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-5">
                                        <span>Bag,kids</span>
                                        <h1>Black friday</h1>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor
                                            incididunt ut labore et dolore
                                        </p>
                                        <a href="/shop" class="primary-btn">Shop Now</a>
                                    </div>
                                </div>
                                <div class="off-card">
                                    <h2>Sale <span>50%</span></h2>
                                </div>
                            </div>
                        </div>
                        <div class="single-hero-items set-bg" data-setbg="./public/img/hero-2.jpg">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-5">
                                        <span>Bag,kids</span>
                                        <h1>Black friday</h1>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor
                                            incididunt ut labore et dolore
                                        </p>
                                        <a href="#" class="primary-btn">Shop Now</a>
                                    </div>
                                </div>
                                <div class="off-card">
                                    <h2>Sale <span>50%</span></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Hero Section End -->

                <!-- Banner Section Begin -->
                <div class="banner-section spad">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="single-banner">
                                    <img src="./public/img/banner-1.jpg" alt="" />
                                    <div class="inner-text">
                                        <h4>Men’s</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="single-banner">
                                    <img src="./public/img/banner-2.jpg" alt="" />
                                    <div class="inner-text">
                                        <h4>Women’s</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="single-banner">
                                    <img src="./public/img/banner-3.jpg" alt="" />
                                    <div class="inner-text">
                                        <h4>Kid’s</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Banner Section End -->

                <!-- Women Banner Section Begin -->
                <section class="women-banner spad">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="product-large set-bg" data-setbg="./public/img/products/women-large.jpg">
                                    <h2>Women’s</h2>
                                    <a href="#">Discover More</a>
                                </div>
                            </div>
                            <div class="col-lg-8 offset-lg-1">
                                <div class="filter-control">
                                    <ul>
                                        <li class="active">Clothings</li>
                                        <li>HandBag</li>
                                        <li>Shoes</li>
                                        <li>Accessories</li>
                                    </ul>
                                </div>
                                <div class="product-slider owl-carousel">
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/women-1.jpg" alt="" />
                                            <div class="sale">Sale</div>
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Coat</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div class="product-price">
                                                $14.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/women-2.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Guangzhou sweater</h5>
                                            </a>
                                            <div class="product-price">$13.00</div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/women-3.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div class="product-price">$34.00</div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/women-4.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Converse Shoes</h5>
                                            </a>
                                            <div class="product-price">$34.00</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Women Banner Section End -->

                <!-- Deal Of The Week Section Begin-->
                <section class="deal-of-week set-bg spad" data-setbg="./public/img/time-bg.jpg">
                    <div class="container">
                        <div class="col-lg-6 text-center">
                            <div class="section-title">
                                <h2>Deal Of The Week</h2>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed<br />
                                    do ipsum dolor sit amet, consectetur adipisicing elit
                                </p>
                                <div class="product-price">
                                    $35.00
                                    <span>/ HanBag</span>
                                </div>
                            </div>
                            <div class="countdown-timer" id="countdown">
                                <div class="cd-item">
                                    <span>56</span>
                                    <p>Days</p>
                                </div>
                                <div class="cd-item">
                                    <span>12</span>
                                    <p>Hrs</p>
                                </div>
                                <div class="cd-item">
                                    <span>40</span>
                                    <p>Mins</p>
                                </div>
                                <div class="cd-item">
                                    <span>52</span>
                                    <p>Secs</p>
                                </div>
                            </div>
                            <a href="#" class="primary-btn">Shop Now</a>
                        </div>
                    </div>
                </section>
                <!-- Deal Of The Week Section End -->

                <!-- Man Banner Section Begin -->
                <section class="man-banner spad">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="filter-control">
                                    <ul>
                                        <li class="active">Clothings</li>
                                        <li>HandBag</li>
                                        <li>Shoes</li>
                                        <li>Accessories</li>
                                    </ul>
                                </div>
                                <div class="product-slider owl-carousel">
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/man-1.jpg" alt="" />
                                            <div class="sale">Sale</div>
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Coat</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div class="product-price">
                                                $14.00
                                                <span>$35.00</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/man-2.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Shoes</div>
                                            <a href="#">
                                                <h5>Guangzhou sweater</h5>
                                            </a>
                                            <div class="product-price">$13.00</div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/man-3.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Pure Pineapple</h5>
                                            </a>
                                            <div class="product-price">$34.00</div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="./public/img/products/man-4.jpg" alt="" />
                                            <div class="icon">
                                                <i class="icon_heart_alt"></i>
                                            </div>
                                            <ul>
                                                <li class="w-icon active">
                                                    <a href="#"><i class="icon_bag_alt"></i></a>
                                                </li>
                                                <li class="quick-view"><a href="#">+ Quick View</a></li>
                                                <li class="w-icon">
                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">Towel</div>
                                            <a href="#">
                                                <h5>Converse Shoes</h5>
                                            </a>
                                            <div class="product-price">$34.00</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 offset-lg-1">
                                <div class="product-large set-bg m-large"
                                    data-setbg="./public/img/products/man-large.jpg">
                                    <h2>Men’s</h2>
                                    <a href="#">Discover More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Man Banner Section End -->

                <!-- Instagram Section Begin -->
                <div class="instagram-photo">
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-1.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-2.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-3.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-4.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-5.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                    <div class="insta-item set-bg" data-setbg="./public/img/insta-6.jpg">
                        <div class="inside-text">
                            <i class="ti-instagram"></i>
                            <h5><a href="#">colorlib_Collection</a></h5>
                        </div>
                    </div>
                </div>
                <!-- Instagram Section End -->

                <!-- Latest Blog Section Begin -->
                <section class="latest-blog spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section-title">
                                    <h2>From The Blog</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-md-6">
                                <div class="single-latest-blog">
                                    <img src="./public/img/latest-1.jpg" alt="" />
                                    <div class="latest-text">
                                        <div class="tag-list">
                                            <div class="tag-item">
                                                <i class="fa fa-calendar-o"></i>
                                                May 4,2019
                                            </div>
                                            <div class="tag-item">
                                                <i class="fa fa-comment-o"></i>
                                                5
                                            </div>
                                        </div>
                                        <a href="#">
                                            <h4>The Best Street Style From London Fashion Week</h4>
                                        </a>
                                        <p>
                                            Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                            quaerat
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="single-latest-blog">
                                    <img src="./public/img/latest-2.jpg" alt="" />
                                    <div class="latest-text">
                                        <div class="tag-list">
                                            <div class="tag-item">
                                                <i class="fa fa-calendar-o"></i>
                                                May 4,2019
                                            </div>
                                            <div class="tag-item">
                                                <i class="fa fa-comment-o"></i>
                                                5
                                            </div>
                                        </div>
                                        <a href="#">
                                            <h4>Vogue's Ultimate Guide To Autumn/Winter 2019 Shoes</h4>
                                        </a>
                                        <p>
                                            Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                            quaerat
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="single-latest-blog">
                                    <img src="./public/img/latest-3.jpg" alt="" />
                                    <div class="latest-text">
                                        <div class="tag-list">
                                            <div class="tag-item">
                                                <i class="fa fa-calendar-o"></i>
                                                May 4,2019
                                            </div>
                                            <div class="tag-item">
                                                <i class="fa fa-comment-o"></i>
                                                5
                                            </div>
                                        </div>
                                        <a href="#">
                                            <h4>How To Brighten Your Wardrobe With A Dash Of Lime</h4>
                                        </a>
                                        <p>
                                            Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                            quaerat
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="benefit-items">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="single-benefit">
                                        <div class="sb-icon">
                                            <img src="./public/img/icon-1.png" alt="" />
                                        </div>
                                        <div class="sb-text">
                                            <h6>Free Shipping</h6>
                                            <p>For all order over 99$</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="single-benefit">
                                        <div class="sb-icon">
                                            <img src="./public/img/icon-2.png" alt="" />
                                        </div>
                                        <div class="sb-text">
                                            <h6>Delivery On Time</h6>
                                            <p>If good have prolems</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="single-benefit">
                                        <div class="sb-icon">
                                            <img src="./public/img/icon-1.png" alt="" />
                                        </div>
                                        <div class="sb-text">
                                            <h6>Secure Payment</h6>
                                            <p>100% secure payment</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Latest Blog Section End -->

                <!-- Partner Logo Section Begin -->
                <div class="partner-logo">
                    <div class="container">
                        <div class="logo-carousel owl-carousel">
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="./public/img/logo-carousel/logo-1.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="./public/img/logo-carousel/logo-2.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="./public/img/logo-carousel/logo-3.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="./public/img/logo-carousel/logo-4.png" alt="" />
                                </div>
                            </div>
                            <div class="logo-item">
                                <div class="tablecell-inner">
                                    <img src="./public/img/logo-carousel/logo-5.png" alt="" />
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
                                        <a href="#"><img src="./public/img/footer-logo.png" alt="" /></a>
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
                <script src="./assets/js/jquery-3.3.1.min.js"></script>
                <script src="./assets/js/bootstrap.min.js"></script>
                <script src="./assets/js/jquery-ui.min.js"></script>
                <script src="./assets/js/jquery.countdown.min.js"></script>
                <script src="./assets/js/jquery.nice-select.min.js"></script>
                <script src="./assets/js/jquery.zoom.min.js"></script>
                <script src="./assets/js/jquery.dd.min.js"></script>
                <script src="./assets/js/jquery.slicknav.js"></script>
                <script src="./assets/js/owl.carousel.min.js"></script>
                <script src="./assets/js/main.js"></script>

                <script type="module">
                    import Toast from './assets/js/Toast/Toast.js';

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
			</script>
		</body>

            </html>