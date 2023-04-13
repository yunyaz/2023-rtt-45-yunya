<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Philly Sports Fan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/ab259512ed.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/pub/CSS/global.css">
</head>

<body>
<nav class="navbar navbar-expand-lg px-3 py-4">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/index">Philly Sports Fan</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="navbar-nav">
                
                <div class="d-inline-flex ps-4">
                    <a class="pt-1" href="/eagles"><img src="/pub/images/icons/eagles_mascot.gif"></a>
                    <a class="nav-link ps-2" href="/eagles">Eagles</a>
                </div>
                <div class="d-inline-flex ps-4">
                    <a class="pt-1" href="/phillies"><img src="/pub/images/icons/phillies_mascot.png"></a>
                    <a class="nav-link" href="/phillies">Phillies</a>
                </div>
                <div class="d-inline-flex ps-4">
                    <a class="" href="/76ers"><img style="height: 90%" src="/pub/images/icons/76ers_mascot.png"></a>
                    <a class="nav-link" href="/76ers">76ers</a>
                </div>
                <div class="d-inline-flex ps-4">
                    <a class="pt-1" href="/flyers"><img src="/pub/images/icons/flyers_mascot.png"></a>
                    <a class="nav-link" href="/flyers">Flyers</a>
                </div>
                <div class="d-inline-flex ps-4">
                    <a class="pt-1" href="/union"><img src="/pub/images/icons/union_mascot.png"></a>
                    <a class="nav-link" href="/Union">Union</a>
                </div>
            </div>
        </div>
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-secondary me-5" type="submit">Search</button>
        </form>

        <sec:authorize access="hasAnyAuthority('ADMIN')">
            <div class="dropdown me-2">
                <button id="adminDropdown" class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    Admin
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/admin/searchProduct">Search Product</a></li>
                    <li><a class="dropdown-item" href="/admin/addProduct">Add Product</a></li>
                </ul>
            </div>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a class="nav-link mx-3" href="/account/login">My Account</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="dropdown me-3">
                <button id="accountDropdown" class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    Hi <sec:authentication property="principal.username" />
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/account/detail">My Account</a></li>
                    <li><a class="dropdown-item" href="/account/logout">Log out</a></li>
                </ul>
            </div>
        </sec:authorize>
        <a href="" class="cart position-relative d-inline-flex mt-1" aria-label="View your shopping cart">
            <i class="fa-solid fa-cart-shopping"></i>
            <span class="cart-basket d-flex align-items-center justify-content-center">0</span>
        </a>


        <!--
        <i class="fa badge fa-lg" value=5>&#xf290;</i>
        <i class="fa badge fa-lg" value=8>&#xf07a;</i>
        <a class="nav-link ps-3" href="/Cart">Cart</a>
        -->
    </div>
</nav>
