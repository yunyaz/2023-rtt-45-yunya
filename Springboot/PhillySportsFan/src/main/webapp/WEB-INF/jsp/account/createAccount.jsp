<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5" style="background-color: #ede6f1; height: 750px">
    <div class="row justify-content-center">
        <div class="card pb-3 justify-content-center" style="width: 25%;">
            <div class="card-body pb-3">
                <form action="/account/createAccountSubmit" method="POST">
                    <div class="mb-3">
                        <label for="firstName" class="form-label">First Name*</label>
                        <input type="text" class="form-control" id="firstName" name="firstName"
                               aria-describedby="firstNameHelp" value="${form.firstName}">
                        <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                            <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                                <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="form-label">Last Name*</label>
                        <input type="text" class="form-control" id="lastName" name="lastName"
                               aria-describedby="lastNameHelp" value="${form.lastName}">
                        <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                            <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                                <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address*</label>
                        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                               value="${form.email}">
                        <c:if test="${bindingResult.hasFieldErrors('email')}">
                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password*</label>
                        <input type="text" class="form-control" id="password" name="password"
                               aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Password must contain at least one uppercase letter,
                            one
                            lowercase letter, one digit, and one of !@#$ symbols
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('password')}">
                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password*</label>
                        <input type="text" class="form-control" id="confirmPassword" name="confirmPassword"
                               aria-describedby="confirmPasswordHelp">
                        <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                            <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                                <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="form-check mb-3">
                        <input class="form-check-input" type="checkbox" id="subscription" name="subscription"
                               value="true">
                        <label class="form-check-label" for="subscription">
                            Yes! Subscribe me for exciting news about products, exclusive offers and more.
                        </label>
                    </div>
                    <div class="row" style="padding-left: 13px; padding-right: 13px">
                        <button id="submitBtn" type="submit" class="btn btn-primary">Create Account</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</section>

<!--
<script src="/pub/js/createAccount.js"></script>
-->

<jsp:include page="../include/footer.jsp"/>