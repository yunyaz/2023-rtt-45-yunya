let submitBtn = document.getElementById("submitBtn");

submitBtn.addEventListener("click", () => {
    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    checkEmail(emailInput, emailText);

    let passwordInput = document.getElementById("password");
    let passwordText = document.getElementById("passwordHelp");
    checkPassword(passwordInput, passwordText);
})

function checkEmail(emailInput, emailText) {
    let emailValue = emailInput.value;
    if (emailValue === '') {
        let msg = "Please enter your email";
        markRed(emailInput, emailText, msg);
    } else {
        emailText.style.cssText = "color:grey";
    }
}

function checkPassword(passwordInput, passwordText) {
    let passwordValue = passwordInput.value;
    if (passwordValue === '') {
        let msg = "Please enter your password";
        markRed(passwordInput, passwordText, msg);
    }
}

function markRed(input, text, message) {
    input.classList.add("is-invalid");
    text.innerHTML = message;
    text.style.cssText = "color:red";
    input.value = "";
}

let cancelBtn = document.getElementById("cancelBtn");

cancelBtn.addEventListener("click", () => {
    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    removeRed(emailInput, emailText);
    
    let passwordInput = document.getElementById("password");
    let passwordText = document.getElementById("passwordHelp");
    removeRed(passwordInput, passwordText);
})

function removeRed(input, text) {
    input.classList.remove("is-invalid");
    input.value = "";
    text.innerHTML = "";
}