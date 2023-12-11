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
                <c:when test="${user.email != null}">
                    <a href="/profile" class="login-panel">Welcome back,
                        <strong>
                            <c:out value='${fn:split(user.email, "@")[0]}' />
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
                    <form action="search" method="get">
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
                            <span>${favoritesQuantity}</span>
                        </a>
                        <div class="cart-hover">
                            <div class="select-items">
                                <table>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${empty favorites.products}">
                                                <tr>
                                                    <td class="text-center" style="font-weight: bold;">You don't
                                                        have any favorites recently...</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach items="${favorites.products}" var="product">
                                                    <tr>
                                                        <td class="si-pic">
                                                            <c:if test="${not empty product.imageUrl}">
                                                                <img src="${product.imageUrl}" alt="${product.name}" />
                                                            </c:if>
                                                        </td>
                                                        <td class="si-text">
                                                            <div class="product-selected">
                                                                <p>$${product.price}</p>
                                                                <h6>${product.name}</h6>
                                                            </div>
                                                        </td>
                                                        <td class="si-close">
                                                            <a href="/favorites?action=remove&id=${product.productId}"
                                                                class="ti-close"></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>

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
                                                    <td class="text-center" style="font-weight: bold;">Your cart is
                                                        empty. Buy some?</td>
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