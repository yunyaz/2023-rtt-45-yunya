<jsp:include page="../include/header.jsp" />

<section class="py-5" style="background-color: #ede6f1; height: 750px">
    <div class="container pb-3 text-center">
        <h2>Create New Account</h2>
    </div>
    <div class="container pb-3" style="width: 30%;">
        <form>
            <div class="mb-3">
                <label for="email" class="form-label">Email address*</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else</div>
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name*</label>
                <input type="text" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                <div id="firstNameHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name*</label>
                <input type="text" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password*</label>
                <input type="text" class="form-control" id="password" aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Password must contain at least one uppercase letter, one
                    lowercase letter, one digit, and one of !@#$ symbols</div>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password*</label>
                <input type="text" class="form-control" id="confirmPassword"
                       aria-describedby="confirmPasswordHelp">
                <div id="confirmPasswordHelp" class="form-text"></div>
            </div>
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Yes! Subscribe me for exciting news about products, exclusive offers and more.
                </label>
            </div>
            <button id="submitBtn" type="button" class="btn btn-primary mt-3 px-5 me-3 text-center">Create</button>
            <button id="cancelBtn" type="button" class="btn btn-secondary mt-3 px-5">Cancel</button>
        </form>
    </div>
</section>

<script src="/pub/js/createAccount.js"></script>

<jsp:include page="../include/footer.jsp" />