<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section class="pt-5 bg-light-grey">
    <div class="container text-center">
        <h1 class="m-0">Login</h1>
    </div>
</section>

<c:if test="${param['error'] != null}">
    <section class="pt-5 bg-light-grey">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <div class="alert alert-danger" role="alert">
                        Invalid Username or Password
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="mt-5 pt-5 mb-5 pb-5">
    <div class="container" style="width: 30%;">
        <!-- the method must always be POST and the action must match the loginProcessingUrl-->
        <form action="/login/loginpost" method="POST">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <!--the name attribute should be "username"-->
                <input type="email" class="form-control" id="email" name="username" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp">
            </div>
            <button type="submit" class="btn btn-primary mt-3 me-3">Login Account</button>
        </form>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />