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

                        <!--
                        <button type="radio" name="size" value="S" class="btn btn-outline-dark me-2" style="width: 40px;" name="">S</button>
                        <button type="radio" name="size" value="M" class="btn btn-outline-dark me-2" style="width: 40px;">M</button>
                        <button type="radio" name="size" value="L" class="btn btn-outline-dark me-2" style="width: 40px;">L</button>
                        <button type="radio" name="size" value="XL" class="btn btn-outline-dark me-2">XL</button>
                        <button type="radio" name="size" value="2XL" class="btn btn-outline-dark">2XL</button>
                        -->
                    </div>
                    <div class="mb-5">
                        <h6>Quantity</h6>
                        <div class="row mb-3">
                            <div class="col-3">
                                <select id="quantity" name="quantity" class="form-select" aria-label="select quantity" style="width: 100px;">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
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