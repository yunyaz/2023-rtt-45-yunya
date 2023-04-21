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
                        <div class="col-3">
                            <h6>Size</h6>
                            <select id="size" name="size" class="form-select" aria-label="select size"
                                    style="width: 100px;">
                                <c:forEach items="${jerseySize}" var="size">
                                    <option value="${size}">${size}</option>
                                </c:forEach>
                            </select>
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
                    <div class="row mb-5 px-3">
                            <button type="submit" class="btn btn-dark">Add to Cart</button>
                    </div>
                    <div class="mb-5">
                        <h6>Description</h6>
                        <p>${product.description}</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>