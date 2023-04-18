<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

<section class="border-bottom">
    <ul class="nav justify-content-evenly">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/team/${teamName}/jerseys">Jerseys</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/team/${teamName}/t-shirts">T-shirts</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/team/${teamName}/sweatshirts">Sweatshirts</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/team/${teamName}/hats">Hats</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/team/${teamName}/accessories">Accessories</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/team/${teamName}/collectibles">Collectibles</a>
        </li>
    </ul>
</section>

<section class="mt-5" style="height: 1150px">
    <div class="container">
        <div class="row pt-3">
            <c:forEach items="${productList}" var="product">
                <div class="col-3 mb-5">
                    <div class="card border border-0" style="height: 450px;">
                        <a href="/detail/${product.id}">
                            <img class="card-img-top" src="${product.imgUrl}" alt="">
                            <div class="card-body">
                                <p class="price" style="color: #575a5e">$${product.price}</p>
                                <h6 class="card-title mb-0 pb-0" style="color: #575a5e">${product.productName}</h6>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>