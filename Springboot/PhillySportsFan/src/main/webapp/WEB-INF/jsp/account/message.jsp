<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5">
<div class="row justify-content-center ">
<c:if test="${true}">
    <div class="alert text-center align-middle mt-5 py-5" role="alert" style="width: 400px; color: black; background-color: #f4f6f8">
        <i class="fa-solid fa-check fa-2xl" style="color: #434ea3;"></i>
        <h5 class="pt-4 pb-2">Account created successfully!</h5>
        <h5>Welcome to Philly Sports Shop!</h5>
        <a id="startShopping" href="/index" style="color: black; text-decoration-color: black"><h5 class="pt-5 pb-2">Start shopping</h5></a>
    </div>
</c:if>
</div>
</section>



<div class="col-2"></div>
<div class="col-3">
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
            <fmt:formatNumber type="number" pattern="###.00" value="${shipping}"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col">
            Sales Tax
        </div>
        <div class="col text-end">
            <c:set var="tax" value="${orderTotal * 0.06}"/>
            $
            <fmt:formatNumber type="number" pattern="###.00" value="${tax}"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col">
            Total
        </div>
        <div class="col text-end">
            $
            <fmt:formatNumber type="number" pattern="###.00" value="${orderTotal + shipping + tax}"/>
        </div>
    </div>
    <hr>
</div>