
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

function checkPassword(passwordInput, passwordText) {
    let passwordValue = passwordInput.value;
    if (passwordValue === '') {
        let msg = "Please enter your password";
        markRed(passwordInput, passwordText, msg);
    } else {
        removeRed(passwordInput, passwordText);
    }
}

function markRed(input, text, message) {
    input.classList.add("is-invalid");
    text.innerHTML = message;
    text.style.cssText = "color:red";
    input.value = "";
}

function removeRed(input, text) {
    input.classList.remove("is-invalid");
    text.style.cssText = "color:grey";
}


let cancelBtn = document.getElementById("cancelBtn");

cancelBtn.addEventListener("click", () => {
    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    reset(emailInput, emailText);

    let passwordInput = document.getElementById("password");
    let passwordText = document.getElementById("passwordHelp");
    reset(passwordInput, passwordText);

    let dateInput = document.getElementById("eventDate");
    let dateText = document.getElementById("dateHelp");
    reset(dateInput, dateText);

})

function reset(input, text) {
    removeRed(input, text);
    input.value = "";
    text.innerHTML = "";
}
