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
                <title>Fashi | Shop</title>

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
                <link rel="stylesheet" href="../assets/css/toast.css" type="text/css">
                <link rel="stylesheet" href="../assets/css/style.css" type="text/css">
            </head>

            <body>
                <!-- Page preloader -->
                <div id="preloader">
                    <div class="loader"></div>
                </div>

                <!-- Header Section Begin -->
                <%@ include file="../includes/header.jsp" %>


                <!-- Header End -->

                    <!-- Breadcrumb Section Begin -->
                    <div class="breadcrumb-section">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="breadcrumb-text">
                                        <a href="/"><i class="fa fa-home"></i> Home</a>
                                        <span>Shop</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Breadcrumb Section Begin -->

                    <!-- Product Shop Section Begin -->
                    <section class="product-shop spad">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
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
                                <div class="col-lg-9 order-1 order-lg-2">
                                    <div class="product-show-option">
                                        <div class="row">
                                            <div class="col-lg-7 col-md-7">
                                                <div class="select-option">
                                                    <select class="sorting">
                                                        <option value="">Default Sorting</option>
                                                    </select>
                                                    <select class="p-show">
                                                        <option value="">Show: ${fn:length(products)} Products</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-lg-5 col-md-5 text-right">
                                                <div id="productCount" style="display:none;">
                                                    ${fn:length(products)}
                                                </div>
                                                <p id="displayCount">Show 01 - 09 Of ${fn:length(products)} Products</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-list">
                                        <div class="row">
                                            <c:forEach items="${products}" var="product">
                                                <div class="col-lg-4 col-sm-6">
                                                    <div class="product-item">
                                                        <div class="pi-pic">
                                                            <c:if test="${not empty product.imageUrl}">
                                                                <img src="${product.imageUrl}" alt="${product.name}">
                                                            </c:if>
                                                            <div class="icon">
                                                            <a class="icon_heart_alt" href="/favorites?action=add&id=${product.productId}"></a>
                                                            </div>
                                                            <ul>
                                                                <li class="w-icon active">
                                                                    <a href="#"
                                                                        onclick="window.location.href='/shop/addToCart?id=${product.productId}&currentPage=' + encodeURIComponent(window.location.href); return false;">
                                                                        <i class="icon_bag_alt"></i>
                                                                    </a>
                                                                </li>
                                                                <li class="quick-view">
                                                                    <a href="/shop/viewProduct?id=${product.productId}">+
                                                                        Quick View</a>
                                                                </li>
                                                                <li class="w-icon">
                                                                    <a href="#"><i class="fa fa-random"></i></a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="pi-text">
                                                            <c:if test="${not empty product.category}">
                                                                <div class="catagory-name">${product.category}</div>
                                                            </c:if>
                                                            <a href="#">
                                                                <h5>${product.name}</h5>
                                                            </a>
                                                            <div class="product-price">
                                                                $${product.price}
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="loading-more">
                                        <i class="icon_loading"></i>
                                        <a href="#" id="loadMoreBtn" onclick="loadMoreProducts(); return false;">
                                            Loading More
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- Product Shop Section End -->

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

                        let productsDisplayed = 9;

                        function loadMoreProducts() {
                            const allProducts = document.querySelectorAll('.product-item');
                            const nextLimit = productsDisplayed + 9;
                            let newProductsShown = false;

                            allProducts.forEach((product, index) => {
                                if (index < nextLimit && product.style.display !== 'block') {
                                    product.style.display = 'block';
                                    newProductsShown = true;
                                }
                            });

                            productsDisplayed = nextLimit;

                            if (!newProductsShown) {
                                displayToast('There are no more products to display.', 'Notice!', 'info');
                                document.getElementById('loadMoreBtn').style.display = 'none';
                            }

                            updateDisplayedProductCount('${totalProductCount}');
                            updateShowOption();
                        };

                        function updateShowOption() {
                            const showOption = document.querySelector('.p-show option');
                            showOption.textContent = `Show: ${productsDisplayed}`;
                        };

                        function updateDisplayedProductCount(totalProductCount) {
                            const displayCountElement = document.getElementById('displayCount');
                            displayCountElement.textContent = "Show ${fn:length(products)} Of ${totalProductCount} Products";
                        };

                        document.addEventListener('DOMContentLoaded', () => {
                            loadMoreProducts();
                            document.getElementById('loadMoreBtn').addEventListener('click', loadMoreProducts);
                            updateDisplayedProductCount("${totalProductCount}");
                            updateShowOption();

                            const filterForm = document.getElementById('filterForm');
                            filterForm.addEventListener('submit', function (e) {
                                e.preventDefault();
                                displayToast('Applying filters...', 'Filter!', 'info');
                            });
                        });
                    </script>
            </body>

            </html>