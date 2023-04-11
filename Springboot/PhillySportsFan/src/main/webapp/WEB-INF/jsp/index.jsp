<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<section style="background-color: #ede6f1; height: 1150px">
    <div class="container">
        <div class="row pt-3">
        <c:forEach items="${productList}" var="product">
            <div class="col">
                <div class="card" style="width: 300px;">
                    <img class="productImages" src="${product.imgUrl}" class="card-img-top" alt="">
                    <div class="card-body">
                        <h6 class="card-title">${product.productName}</h6>
                        <p class="card-text"></p>
                        <span class="mx-3">$${product.price}</span><a href="#" class="addCartBtn btn ms-5 px-4">Add cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />