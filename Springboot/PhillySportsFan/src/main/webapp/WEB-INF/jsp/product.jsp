<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

<section class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-7">
                <img class="productImage" src="${product.imgUrl}" alt="">
            </div>
            <div class="col-5">
                <div class="row">
                    <h5>${product.productName}</h5>
                </div>
                <div class="row">
                    <h6>${product.price}</h6>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>