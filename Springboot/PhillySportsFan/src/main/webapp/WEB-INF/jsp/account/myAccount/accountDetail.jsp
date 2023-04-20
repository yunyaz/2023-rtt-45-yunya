<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section class="py-5" style="height: 900px">
    <div class="container text-center">
        <h2>My Account</h2>
    </div>
    <div class="container py-3 col-3">
        <form action="/account/changeEmail" method="POST">
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
                <label for="email" class="form-label">Confirm email address*</label>
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
                <c:if test="${bindingResult.hasFieldErrors('password')}">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="row" style="padding-left: 13px; padding-right: 13px">
                <button id="" type="submit" class="btn btn-primary">Change Email Address</button>
            </div>
        </form>
        <form class="mt-5" action="/account/changePassword" method="POST">
            <div class="mb-3">
                <label for="password" class="form-label">Current Password*</label>
                <input type="text" class="form-control" id="password" name="password"
                       aria-describedby="passwordHelp">
                <c:if test="${bindingResult.hasFieldErrors('password')}">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">New Password*</label>
                <input type="text" class="form-control" id="password" name="password"
                       aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Password must contain at least one uppercase letter,
                    one lowercase letter, one digit, and one of !@#$ symbols
                </div>
                <c:if test="${bindingResult.hasFieldErrors('password')}">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm New Password*</label>
                <input type="text" class="form-control" id="confirmPassword" name="confirmPassword"
                       aria-describedby="confirmPasswordHelp">
                <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                    <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                        <div class="errorMessage" style="color: red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="row" style="padding-left: 13px; padding-right: 13px">
                <button id="submitBtn" type="submit" class="btn btn-primary">Change Password</button>
            </div>

        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>