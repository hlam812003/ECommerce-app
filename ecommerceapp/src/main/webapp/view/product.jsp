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
                <title>Fashi | Product</title>

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
                    <%@ include file="../includes/header.jsp" %>
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
                                    <span>Detail</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb Section Begin -->

                <!-- Product Shop Section Begin -->
                <section class="product-shop spad page-details">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-3">
                                <form action="/shop" method="GET" id="filterForm">
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Categories</h4>
                                        <div class="filter-catagories">
                                            <label><input type="checkbox" name="category" value="Men" onChange="this.form.submit()"> Men</label>
                                            <label><input type="checkbox" name="category" value="Women" onChange="this.form.submit()">
                                                Women</label>
                                            <label><input type="checkbox" name="category" value="Kids" onChange="this.form.submit()"> Kids</label>
                                        </div>
                                    </div>
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Brand</h4>
                                        <div class="fw-brand-check">
                                            <div class="bc-item">
                                                <label for="bc-calvin">
                                                    Calvin Klein
                                                    <input type="checkbox" id="bc-calvin" name="brand"
                                                        value="Calvin Klein" onChange="this.form.submit()">
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                            <div class="bc-item">
                                                <label for="bc-diesel">
                                                    Diesel
                                                    <input type="checkbox" id="bc-diesel" name="brand"
                                                        value="Diesel" onChange="this.form.submit()">
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                            <div class="bc-item">
                                                <label for="bc-polo">
                                                    Polo
                                                    <input type="checkbox" id="bc-polo" name="brand" value="Polo" onChange="this.form.submit()">
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                            <div class="bc-item">
                                                <label for="bc-addidas">
                                                    Addidas
                                                    <input type="checkbox" id="bc-addidas" name="brand"
                                                        value="Addidas" onChange="this.form.submit()">
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Price</h4>
                                        <div class="filter-range-wrap">
                                            <div class="range-slider">
                                                <div class="price-input">
                                                    <input type="text" id="minamount" value="$0" readonly>
                                                    <input type="text" id="maxamount" value="$100" readonly>
                                                    <input type="hidden" id="hiddenMinAmount" name="minPrice">
                                                    <input type="hidden" id="hiddenMaxAmount" name="maxPrice">
                                                </div>
                                            </div>
                                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                                data-min="0" data-max="100">
                                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                                <span tabindex="0"
                                                    class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                                <span tabindex="0"
                                                    class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                            </div>
                                        </div>
                                        <!-- <button type="submit" class="filter-btn">Filter</button> -->
                                    </div>
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Color</h4>
                                        <div class="fw-color-choose">
                                            <div class="cs-item">
                                                <input type="radio" id="cs-black" name="color" value="Black" onChange="this.form.submit()">
                                                <label class="cs-black" for="cs-black">Black</label>
                                            </div>
                                            <div class="cs-item">
                                                <input type="radio" id="cs-violet" name="color" value="Violet" onChange="this.form.submit()">
                                                <label class="cs-violet" for="cs-violet">Violet</label>
                                            </div>
                                            <div class="cs-item">
                                                <input type="radio" id="cs-blue" name="color" value="Blue" onChange="this.form.submit()">
                                                <label class="cs-blue" for="cs-blue">Blue</label>
                                            </div>
                                            <div class="cs-item">
                                                <input type="radio" id="cs-yellow" name="color" value="Yellow" onChange="this.form.submit()">
                                                <label class="cs-yellow" for="cs-yellow">Yellow</label>
                                            </div>
                                            <div class="cs-item">
                                                <input type="radio" id="cs-red" name="color" value="Red" onChange="this.form.submit()">
                                                <label class="cs-red" for="cs-red">Red</label>
                                            </div>
                                            <div class="cs-item">
                                                <input type="radio" id="cs-green" name="color" value="Green" onChange="this.form.submit()">
                                                <label class="cs-green" for="cs-green">Green</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Size</h4>
                                        <div class="fw-size-choose">
                                            <div class="sc-item">
                                                <input type="radio" id="s-size" name="size" value="s" onChange="this.form.submit()">
                                                <label for="s-size">s</label>
                                            </div>
                                            <div class="sc-item">
                                                <input type="radio" id="m-size" name="size" value="m" onChange="this.form.submit()">
                                                <label for="m-size">m</label>
                                            </div>
                                            <div class="sc-item">
                                                <input type="radio" id="l-size" name="size" value="l" onChange="this.form.submit()">
                                                <label for="l-size">l</label>
                                            </div>
                                            <div class="sc-item">
                                                <input type="radio" id="xl-size" name="size" value="xl" onChange="this.form.submit()">
                                                <label for="xl-size">xl</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter-widget">
                                        <h4 class="fw-title">Tags</h4>
                                        <div class="fw-tags">
                                            <label><input type="checkbox" name="tags" value="Towel" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Towel</label>
                                            <label><input type="checkbox" name="tags" value="Shoes" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Shoes</label>
                                            <label><input type="checkbox" name="tags" value="Coat" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Coat</label>
                                            <label><input type="checkbox" name="tags" value="Dresses" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Dresses</label>
                                            <label><input type="checkbox" name="tags" value="Trousers" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Trousers</label>
                                            <label><input type="checkbox" name="tags" value="Men's hats" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Men's hats</label>
                                            <label><input type="checkbox" name="tags" value="T-Shirts" onChange="this.form.submit()"><span
                                                class="checkmark"></span> T-Shirts</label>
                                            <label><input type="checkbox" name="tags" value="Backpack" onChange="this.form.submit()"><span
                                                    class="checkmark"></span> Backpack</label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-9">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="product-pic-zoom">
                                            <img class="product-big-img" src="${product.imageUrl}" alt="${product.name}">
                                            <div class="zoom-icon">
                                                <i class="fa fa-search-plus"></i>
                                            </div>
                                        </div>
                                        <div class="product-thumbs">
                                            <div class="product-thumbs-track ps-slider owl-carousel">
                                                <div class="pt active"
                                                    data-imgbigurl="./public/img/product-single/product-1.jpg"><img
                                                        src="../public/img/product-single/product-1.jpg" alt=""></div>
                                                <div class="pt"
                                                    data-imgbigurl="./public/img/product-single/product-2.jpg"><img
                                                        src="../public/img/product-single/product-2.jpg" alt=""></div>
                                                <div class="pt"
                                                    data-imgbigurl="./public/img/product-single/product-3.jpg"><img
                                                        src="../public/img/product-single/product-3.jpg" alt=""></div>
                                                <div class="pt"
                                                    data-imgbigurl="./public/img/product-single/product-3.jpg"><img
                                                        src="../public/img/product-single/product-3.jpg" alt=""></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="product-details">
                                            <div class="pd-title">
                                                <span>${product.brand}</span>
                                                <h3>${product.name}</h3>
                                                <a href="#" class="heart-icon"><i class="icon_heart_alt"></i></a>
                                            </div>
                                            <div class="pd-desc">
                                                <p>${product.description}</p>
                                                <h4>$${product.price} 
                                                    <!-- <span>629.99</span> -->
                                                </h4>
                                            </div>
                                            <div class="pd-color">
                                                <h6>Color</h6>
                                                <div class="pd-color-choose">
                                                    <div class="cc-item">
                                                        <input type="radio" id="cc-black">
                                                        <label for="cc-black"></label>
                                                    </div>
                                                    <div class="cc-item">
                                                        <input type="radio" id="cc-yellow">
                                                        <label for="cc-yellow" class="cc-yellow"></label>
                                                    </div>
                                                    <div class="cc-item">
                                                        <input type="radio" id="cc-violet">
                                                        <label for="cc-violet" class="cc-violet"></label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="pd-size-choose">
                                                <div class="sc-item">
                                                    <input type="radio" id="sm-size">
                                                    <label for="sm-size">s</label>
                                                </div>
                                                <div class="sc-item">
                                                    <input type="radio" id="md-size">
                                                    <label for="md-size">m</label>
                                                </div>
                                                <div class="sc-item">
                                                    <input type="radio" id="lg-size">
                                                    <label for="lg-size">l</label>
                                                </div>
                                                <div class="sc-item">
                                                    <input type="radio" id="xl-size">
                                                    <label for="xl-size">xs</label>
                                                </div>
                                            </div>
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="number" name="quantity"
                                                    value="${item.quantity}" form="update-quantity" min="1">
                                                </div>
                                                <a href="#" class="primary-btn pd-cart" 
                                                    onclick="window.location.href='/shop/addToCart?id=${product.productId}&currentPage=' + encodeURIComponent(window.location.href); return false;">
                                                    Add To Cart
                                                </a>                               
                                            </div>
                                            <ul class="pd-tags">
                                                <li><span>CATEGORIES</span>: ${product.category}</li>
                                                <li><span>TAGS</span>: ${product.tags}</li>
                                            </ul>
                                            <div class="pd-share">
                                                <div class="p-code">Sku : ${product.productId}</div>
                                                <div class="pd-social">
                                                    <a href="#"><i class="ti-facebook"></i></a>
                                                    <a href="#"><i class="ti-twitter-alt"></i></a>
                                                    <a href="#"><i class="ti-linkedin"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- <div class="product-tab">
                                    <div class="tab-item">
                                        <ul class="nav" role="tablist">
                                            <li>
                                                <a class="active" data-toggle="tab" href="#tab-1"
                                                    role="tab">DESCRIPTION</a>
                                            </li>
                                            <li>
                                                <a data-toggle="tab" href="#tab-2" role="tab">SPECIFICATIONS</a>
                                            </li>
                                            <li>
                                                <a data-toggle="tab" href="#tab-3" role="tab">Customer Reviews (02)</a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="tab-item-content">
                                        <div class="tab-content">
                                            <div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
                                                <div class="product-content">
                                                    <div class="row">
                                                        <div class="col-lg-7">
                                                            <h5>Introduction</h5>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                                                sed do
                                                                eiusmod tempor incididunt ut labore et dolore magna
                                                                aliqua. Ut enim
                                                                ad minim veniam, quis nostrud exercitation ullamco
                                                                laboris nisi ut
                                                                aliquip ex ea commodo consequat. Duis aute irure dolor
                                                                in </p>
                                                            <h5>Features</h5>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                                                sed do
                                                                eiusmod tempor incididunt ut labore et dolore magna
                                                                aliqua. Ut enim
                                                                ad minim veniam, quis nostrud exercitation ullamco
                                                                laboris nisi ut
                                                                aliquip ex ea commodo consequat. Duis aute irure dolor
                                                                in </p>
                                                        </div>
                                                        <div class="col-lg-5">
                                                            <img src="../public/img/product-single/tab-desc.jpg" alt="">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="tab-2" role="tabpanel">
                                                <div class="specification-table">
                                                    <table>
                                                        <tr>
                                                            <td class="p-catagory">Customer Rating</td>
                                                            <td>
                                                                <div class="pd-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star-o"></i>
                                                                    <span>(5)</span>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Price</td>
                                                            <td>
                                                                <div class="p-price">$495.00</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Add To Cart</td>
                                                            <td>
                                                                <div class="cart-add">+ add to cart</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Availability</td>
                                                            <td>
                                                                <div class="p-stock">22 in stock</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Weight</td>
                                                            <td>
                                                                <div class="p-weight">1,3kg</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Size</td>
                                                            <td>
                                                                <div class="p-size">Xxl</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Color</td>
                                                            <td><span class="cs-color"></span></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="p-catagory">Sku</td>
                                                            <td>
                                                                <div class="p-code">00012</div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="tab-3" role="tabpanel">
                                                <div class="customer-review-option">
                                                    <h4>2 Comments</h4>
                                                    <div class="comment-option">
                                                        <div class="co-item">
                                                            <div class="avatar-pic">
                                                                <img src="../public/img/product-single/avatar-1.png"
                                                                    alt="">
                                                            </div>
                                                            <div class="avatar-text">
                                                                <div class="at-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star-o"></i>
                                                                </div>
                                                                <h5>Brandon Kelley <span>27 Aug 2019</span></h5>
                                                                <div class="at-reply">Nice !</div>
                                                            </div>
                                                        </div>
                                                        <div class="co-item">
                                                            <div class="avatar-pic">
                                                                <img src="../public/img/product-single/avatar-2.png"
                                                                    alt="">
                                                            </div>
                                                            <div class="avatar-text">
                                                                <div class="at-rating">
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star"></i>
                                                                    <i class="fa fa-star-o"></i>
                                                                </div>
                                                                <h5>Roy Banks <span>27 Aug 2019</span></h5>
                                                                <div class="at-reply">Nice !</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="personal-rating">
                                                        <h6>Your Ratind</h6>
                                                        <div class="rating">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                    </div>
                                                    <div class="leave-comment">
                                                        <h4>Leave A Comment</h4>
                                                        <form action="#" class="comment-form">
                                                            <div class="row">
                                                                <div class="col-lg-6">
                                                                    <input type="text" placeholder="Name">
                                                                </div>
                                                                <div class="col-lg-6">
                                                                    <input type="text" placeholder="Email">
                                                                </div>
                                                                <div class="col-lg-12">
                                                                    <textarea placeholder="Messages"></textarea>
                                                                    <button type="submit" class="site-btn">Send
                                                                        message</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> -->
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Product Shop Section End -->

                <!-- Related Products Section End -->
                <div class="related-products spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section-title">
                                    <h2>Related Products</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="../public/img/products/women-1.jpg" alt="">
                                        <div class="sale">Sale</div>
                                        <div class="icon">
                                            <i class="icon_heart_alt"></i>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a href="#">+ Quick View</a></li>
                                            <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
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
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="../public/img/products/women-2.jpg" alt="">
                                        <div class="icon">
                                            <i class="icon_heart_alt"></i>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a href="#">+ Quick View</a></li>
                                            <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">Shoes</div>
                                        <a href="#">
                                            <h5>Guangzhou sweater</h5>
                                        </a>
                                        <div class="product-price">
                                            $13.00
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="../public/img/products/women-3.jpg" alt="">
                                        <div class="icon">
                                            <i class="icon_heart_alt"></i>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a href="#">+ Quick View</a></li>
                                            <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">Towel</div>
                                        <a href="#">
                                            <h5>Pure Pineapple</h5>
                                        </a>
                                        <div class="product-price">
                                            $34.00
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="../public/img/products/women-4.jpg" alt="">
                                        <div class="icon">
                                            <i class="icon_heart_alt"></i>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a href="#">+ Quick View</a></li>
                                            <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">Towel</div>
                                        <a href="#">
                                            <h5>Converse Shoes</h5>
                                        </a>
                                        <div class="product-price">
                                            $34.00
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Related Products Section End -->

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