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
