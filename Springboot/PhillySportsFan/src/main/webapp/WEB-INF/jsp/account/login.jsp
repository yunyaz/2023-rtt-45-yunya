<jsp:include page="../include/header.jsp"/>

<section class="py-5" style="background-color: #ede6f1; height: 750px">
    <div class="container pb-3 text-center">
        <h3>Sign In</h3>
    </div>
    <div class="container pb-5" style="width: 25%;">
        <form action="/account/loginpost" method="POST">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="username" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password" name="password" aria-describedby="passwordHelp">
            </div>
            <div class="row" style="padding-left: 13px; padding-right: 13px">
                <button id="submitBtn" type="submit" class="btn btn-primary mt-3 me-3">Sign In</button>
            </div>
            <div style="color: black; margin-top: 20px">
                <a style="color: black" href="">Forgot password?</a>
            </div>
        </form>
    </div>
    <div class="container pb-3 text-center">
        <h3>New Customer</h3>
    </div>
    <div class="container pb-3" style="width: 25%;">
        <div class="row" style="padding-left: 13px; padding-right: 13px">
            <a class="btn btn-secondary mb-3" href="/account/createAccount">Create Account</a>
        </div>
    </div>
</section>

<script src="/pub/js/signin.js"></script>

<jsp:include page="../include/footer.jsp"/>