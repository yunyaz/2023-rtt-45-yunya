<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Summer Bakery</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/pub/CSS/style.css">
</head>

<body>
<nav class="navbar navbar-expand-lg px-3 py-4">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/index">Summer Bakery</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="navbar-nav">
                <a class="nav-link ps-3" href="/cake">Cakes</a>
                <a class="nav-link ps-3" href="#">Cupcakes</a>
                <a class="nav-link ps-3" href="#">Cookies</a>
                <a class="nav-link ps-3" href="#">Bread</a>
                <a class="nav-link ps-3" href="#">Drinks</a>
            </div>
        </div>
        <form class="d-flex" role="search">
            <input class="form-control me-3" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-secondary" type="submit">Search</button>
        </form>
        <div class="dropdown ps-4">
            <button id="accountDropdown" class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false">
                My Account
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/signin">Sign In</a></li>
                <li><a class="dropdown-item" href="/createAccount">Create Account</a></li>
            </ul>
        </div>
        <a class="nav-link ps-3" href="/customOrder">Custom Order</a>
    </div>
</nav>
