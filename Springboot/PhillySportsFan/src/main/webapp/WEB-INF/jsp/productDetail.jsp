<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<section class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-7">
                <img class="productImage" src="${product.imgUrl}" alt="">
            </div>
            <div class="col-5">
                <form action="/order/addToCart" method="POST">
                    <input type="hidden" name="productId" value="${product.id}"/>
                    <div class="row mb-3">
                        <h5>${product.productName}</h5>
                    </div>
                    <div class="row mb-5">
                        <h6>$${product.price}</h6>
                    </div>
                    <div class="mb-5">
                        <div class="col-3">
                            <h6>Size</h6>
                            <c:if test="${product.category eq 'Hats'}">
                                <button type="button" class="btn" style="border-color: lightgrey">One Size</button>
                            </c:if>
                            <c:if test="${(product.category ne 'Hats') && (product.category ne 'Accessories') && (product.category ne 'Collectibles')}">
                                <select id="size" name="size" class="form-select" aria-label="select size"
                                        style="width: 100px;">
                                    <c:forEach items="${jerseySize}" var="size">
                                        <option value="${size}">${size}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </div>
                    </div>
                    <div class="mb-5">
                        <div class="col-3">
                            <h6>Quantity</h6>
                            <select id="quantity" name="quantity" class="form-select" aria-label="select quantity"
                                    style="width: 100px;">
                                <c:forEach items="${quantityList}" var="quantity">
                                    <option value="${quantity}">${quantity}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-5 mx-1">
                        <button type="submit" class="btn btn-dark">Add to Cart</button>
                    </div>
                    <div class="mb-5">
                        <h6>Description</h6>
                        <p>${product.description}</p>
                    </div>
                </form>
                <c:if test="${ordered}">
                    <div>
                        <p>
                            <button class="btn btn-dark" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#collapseExample" aria-expanded="false"
                                    aria-controls="collapseExample">
                                Write a review
                            </button>
                        </p>
                        <div class="collapse" id="collapseExample">
                            <form action="/account/reviewSubmit" method="POST">
                                <input type="hidden" name="productId" value="${product.id}"/>
                                <div class="row pb-3">
                                    <div class="rating">
                                        <input type="radio" id="star5" name="rating" value="5"/><label
                                            for="star5"></label>
                                        <input type="radio" id="star4" name="rating" value="4"/><label
                                            for="star4"></label>
                                        <input type="radio" id="star3" name="rating" value="3"/><label
                                            for="star3"></label>
                                        <input type="radio" id="star2" name="rating" value="2"/><label
                                            for="star2"></label>
                                        <input type="radio" id="star1" name="rating" value="1"/><label
                                            for="star1"></label>
                                    </div>
                                </div>
                                <div class="row">
                                     <textarea id="comment" name="comment" class="form-control ms-2 mb-3" rows="5" style="width: 800px"
                                        aria-describedby="descriptionHelp"></textarea>
                                </div>
                                <button type="submit" class="btn btn-dark mb-3">Submit</button>
                            </form>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>

<section class="py-5">
    <div class="container">
        <div class="row">
            <h4>Reviews</h4>
            <hr>
            <c:forEach items="${reviews}" var="review">
                <div class="row">${review.getComment()}</div>
                <hr>
            </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>