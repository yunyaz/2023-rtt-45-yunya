<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<section style="height: 1150px">
    <div class="container">
        <div class="row pt-3">
        <c:forEach items="${productList}" var="product">
            <div class="col-3 mb-5">
                <div class="card" style="height: 500px;">
                    <img class="productImages" src="${product.imgUrl}" class="card-img-top" alt="">
                    <div class="card-body">
                        <p class="price">$${product.price}</p>
                        <a href="/admin/detail/${product.id}"><h6 class="card-title mb-0 pb-0">${product.productName}</h6></a>
                    </div>
                    <div class="card-footer border-white bg-white d-flex justify-content-center">
                        <a href="#" class="addCartBtn btn btn-primary">Add to cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />