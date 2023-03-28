<jsp:include page="include/header.jsp" />

<section class="pt-5 pb-5" style="background-color: rgb(216, 222, 227);">
    <div class="container text-center">
        <h2>Create New Account</h2>
    </div>

</section>

<script>
    function cancelClicked() {
        alert("Cancel clicked");

        let items = document.getElementsByClassName("is-invalid");
        for (i of items) {
            console.log(i);
            i.classList.remove("is-invalid");
        }

        let emailInput = document.getElementById("email");
        emailInput.classList.remove("is-invalid");
        emailInput.value = "";

        let passwordInput = document.getElementById("password");
        passwordInput.classList.remove("is-invalid");

        let confirmPasswordInput = document.getElementById("confirmPassword");
        confirmPasswordInput.classList.remove("is-invalid");
    }
    function formSubmit() {
        let emailInput = document.getElementById("email");
        checkEmail(emailInput);

        let passwordInput = document.getElementById("password");
        let confirmPasswordInput = document.getElementById("confirmPassword");
        checkPasswordMatch(passwordInput, confirmPasswordInput);
    }

    function checkEmail(emailInput) {
        console.log(emailInput);
        let emailValue = emailInput.value;
        if (emailValue === '') {
            emailInput.classList.add("is-invalid");

            let emailText = document.getElementById("emailHelp");
            emailText.innerHTML = "Please Enter your email";
            emailText.style.cssText = "color:red";
        }
    }

    function checkPasswordMatch(passwordInput, confirmPasswordInput) {
        let passwordValue = passwordInput.value;
        let confirmPasswordValue = confirmPasswordInput.value;

        if (passwordValue !== confirmPasswordValue) {
            alert("password does not match");
            passwordInput.classList.add("is-invalid");
            passwordInput.value = "";
            confirmPasswordInput.classList.add("is-invalid");
            confirmPasswordInput.value = "";
        }
    }

    function checkPasswordFormat(passwordInput, confirmPasswordInput) {
        if (passwordValue.length < 8 || /[A-Z]/.test(passwordValue) || /[a-z]/.test(passwordValue) || /[0-9]/.test(passwordValue)) {
            alert("Wrong password format");
            passwordInput.classList.add("is-invalid");
        }
    }

</script>

<section class="mt-5 pt-5 mb-5 pb-5">
    <div class="container" style="width: 50%;">
        <form>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                <div id="firstNameHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Password must contain at least one uppercase letter, one lowercase letter, one digit, and one of !@#$ symbols</div>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">*Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" aria-describedby="confirmPasswordHelp">
                <div id="confirmPasswordHelp" class="form-text"></div>
            </div>
            <button type="button" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Create Account</button>
            <button type="button" class="btn btn-secondary mt-3" onclick="cancelClicked()">Cancel</button>
        </form>

    </div>

</section>

<jsp:include page="include/footer.jsp" />