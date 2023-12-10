<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="description" content="Fashi Dashboard" />
    <meta name="keywords" content="Fashi, unica, creative, html" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />

    <title>Fashi | Admin Login</title>

    <link href="../../view/admin/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <<link href="../../view/admin/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">

    <link href="../../view/admin/css/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css">
    <link href="../../view/admin/css/animate.css" rel="stylesheet" type="text/css">
    <link href="../../view/admin/css/style.css" rel="stylesheet" type="text/css">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">FSH</h1>

            </div>
            <h3>Welcome to Fashi.</h3>
            <p>Login in. To manage your store.</p>
            <form class="m-t" role="form" action="/admin/login" method="post">
                <div class="form-group">
                    <input type="email" name="email" class="form-control" placeholder="Email" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
                <a href="#"><small>Forgot password?</small></a>
            </form>            
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="../../view/admin/js/jquery-3.7.1.js"></script>
    <script src="../../view/admin/js/bootstrap.min.js"></script>
    <script src="../../view/admin/js/plugins/toastr/toastr.min.js"></script>

    <script src="../../view/admin/js/main.js"></script>
</body>

</html>
