<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="include/header.jsp"/>

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
                        <h6>Size</h6>
                        <div class="col-3">
                            <select id="size" name="size" class="form-select" aria-label="select size" style="width: 100px;">
                                <option value="S">S</option>
                                <option value="M">M</option>
                                <option value="L">L</option>
                                <option value="XL">XL</option>
                                <option value="2XL">2XL</option>
                            </select>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h6>Quantity</h6>
                        <div class="row mb-3">
                            <div class="col-3">
                                <select id="quantity" name="quantity" class="form-select" aria-label="select quantity" style="width: 100px;">
                                    <c:forEach items="${quantityList}" var="quantity">
                                        <option value="${quantity}">${quantity}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-9">
                                <div class="row me-2">
                                    <button type="submit" class="btn btn-dark">Add to Cart</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h6>Description</h6>
                        <p>${product.description}</p>
                    </div>

                </form>

            </div>
        </div>
</section>

<jsp:include page="include/footer.jsp"/>