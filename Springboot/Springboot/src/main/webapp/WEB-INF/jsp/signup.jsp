<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<section class="pt-5 pb-5" style="background-color: rgb(216, 222, 227);">
    <div class="container text-center">
        <h2>Create New Account</h2>
    </div>
</section>

<c:if test="${bindingResult.hasFieldErrors()}">
    <section class="pt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <c:forEach items="${bindingResult.getFieldErrors()}" var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="mt-5 pt-5 mb-5 pb-5">
    <div class="container" style="width: 50%;">
        <form action="/signup" method="POST">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email" value="${form.email}" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="fullName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="${form.fullName}" aria-describedby="firstNameHelp">
                <div id="firstNameHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="${form.password}" aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Password must contain at least one uppercase letter, one lowercase letter, one digit, and one of !@#$ symbols</div>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">*Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="${form.confirmPassword}" aria-describedby="confirmPasswordHelp">
                <div id="confirmPasswordHelp" class="form-text"></div>
            </div>
            <button type="submit" class="btn btn-primary mt-3 me-3">Create Account</button>
        </form>

    </div>

</section>

<jsp:include page="include/footer.jsp" />