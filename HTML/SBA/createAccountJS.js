
let submitBtn = document.getElementsByClassName("submitBtn");

submitBtn[0].addEventListener("click", () => {
    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    checkEmail(emailInput, emailText);

    let passwordInput = document.getElementById("password");
    let passwordText = document.getElementById("passwordHelp");
    let confirmPasswordInput = document.getElementById("confirmPassword");
    let confirmPasswordText = document.getElementById("confirmPasswordHelp");
    checkPasswordFormat(passwordInput, passwordText, confirmPasswordInput, confirmPasswordText);
})

function checkEmail(emailInput, emailText) {
    let emailValue = emailInput.value;
    let msg = "";
    if (emailValue === "") {
        msg = "Please enter your email";
        markRed(emailInput, emailText, msg);
    } else if (!emailValue.match(/^\S+@\S+$/)) {
        msg = "Please enter a valid email";
        markRed(emailInput, emailText, msg);
    } else {
        removeRed(emailInput, emailText);
    }
}

function checkPasswordFormat(passwordInput, passwordText, confirmPasswordInput, confirmPasswordText) {
    let passwordValue = passwordInput.value;
    let msg = "";
    if (passwordValue === '') {
        msg = "Please enter your password<br>" + "Password must contain at least one uppercase letter,"
        + "one lowercase letter, one digit, and one of !@#$ symbols";
        markRed(passwordInput, passwordText, msg);
    } else if (!passwordValue.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$])[A-Za-z\d!@#$]{8,}$/)) {
        msg = "Please enter your password in correct format<br>" + "Password must contain at least one uppercase letter,"
        + "one lowercase letter, one digit, and one of !@#$ symbols";
        markRed(passwordInput, passwordText, msg);
    } else {
        checkPasswordMatch(passwordInput, passwordText, confirmPasswordInput, confirmPasswordText);
    }
}

function checkPasswordMatch(passwordInput, passwordText, confirmPasswordInput, confirmPasswordText) {
    let passwordValue = passwordInput.value;
    let confirmPasswordValue = confirmPasswordInput.value;
    let msg = "";
    if (passwordValue !== confirmPasswordValue) {
        msg = passwordText.innerHTML;
        markRed(passwordInput, passwordText, msg);

        msg = "Password does not match";
        markRed(confirmPasswordInput, confirmPasswordText, msg);
    }
}

function markRed(input, text, message) {
    input.classList.add("is-invalid");
    text.innerHTML = message;
    text.style.cssText = "color:red";
    input.value = "";
}



let cancelBtn = document.getElementsByClassName("cancelBtn");

cancelBtn[0].addEventListener("click", () => {
    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    let msg = "We'll never share your email with anyone else";
    removeRed(emailInput, emailText, msg);
    
    let passwordInput = document.getElementById("password");
    let passwordText = document.getElementById("passwordHelp");
    msg = "Password must contain at least one uppercase letter,"
        + "one lowercase letter, one digit, and one of !@#$ symbols";
    removeRed(passwordInput, passwordText, msg);

    let confirmPasswordInput = document.getElementById("confirmPassword");
    let confirmPasswordText = document.getElementById("confirmPasswordHelp");
    msg = "";
    removeRed(confirmPasswordInput, confirmPasswordText, msg);
})

function removeRed(input, text, message) {
    input.classList.remove("is-invalid");
    input.value = "";
    text.innerHTML = message;
    text.style.cssText = "color:grey";
}