<jsp:include page="../include/header.jsp" />

    <section class="py-5" style="background-color: #ede6f1; height: 750px">
        <div class="container pb-5 text-center">
            <h2>Sign In</h2>
        </div>
        <div class="container pb-3" style="width: 30%;">
            <form>
                <div class="mb-3">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="text" class="form-control" id="password" aria-describedby="passwordHelp">
                    <div id="passwordHelp" class="form-text"></div>
                </div>
                <button id="submitBtn" type="button" class="btn mt-3 me-3">Sign In</button>
                <button id="cancelBtn" type="button" class="btn btn-secondary mt-3">Cancel</button>
                <div style="color: black; margin-top: 20px">
                    <a style="color: black" href="">Forget password?</a>
                </div>
            </form>
        </div>
    </section>

    <script src="/pub/js/signin.js"></script>

<jsp:include page="../include/footer.jsp" />