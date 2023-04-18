<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5" style="height: 1100px">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-7">
                <h3>Items in your cart</h3>
                <hr>
                <c:forEach items="${order.getOrderProductList()}" var="orderProduct">
                    <div class="row">
                        <div class="col-3">
                            <img class="cartImage" src="${orderProduct.getProduct().getImgUrl()}" style="width: 150px"
                                 alt="">
                        </div>
                        <div class="col-7">
                            <p>${orderProduct.getProduct().getProductName()}</p>
                            <p>Size: ${orderProduct.getSize()}</p>
                            <p>Quantity: ${orderProduct.getQuantity()}</p>
                        </div>
                        <div class="col-2 text-end">
                            <span>$${orderProduct.getProduct().getPrice()}</span>
                        </div>
                        <hr>
                    </div>
                </c:forEach>
            </div>
            <div class="col-2"></div>
            <div class="col-3">
                <c:if test="${not empty order.getOrderProductList()}">
                    <h3>Order summary</h3>
                    <hr>
                    <div class="row mt-3">
                        <div class="col-7">
                            Subtotal (${totalItems} items)
                        </div>
                        <div class="col text-end">
                            $${orderTotal}
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            Shipping
                        </div>
                        <div class="col text-end">
                            <c:set var="shipping" value="${5}"/>
                            $
                            <fmt:formatNumber type="number" pattern = "###.00" value="${shipping}"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            Sales Tax
                        </div>
                        <div class="col text-end">
                            <c:set var="tax" value="${orderTotal * 0.06}"/>
                            $
                            <fmt:formatNumber type="number" pattern = "###.00" value="${tax}"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            Total
                        </div>
                        <div class="col text-end">
                            $
                            <fmt:formatNumber type="number" pattern = "###.00" value="${orderTotal + shipping + tax}"/>
                        </div>
                    </div>
                    <div class="row mt-5 mx-1">
                        <a class="btn btn-primary" href="/order/checkout">Checkout</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

</section>

<jsp:include page="../include/footer.jsp"/>