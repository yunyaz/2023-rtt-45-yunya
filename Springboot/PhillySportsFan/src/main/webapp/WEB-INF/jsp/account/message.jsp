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