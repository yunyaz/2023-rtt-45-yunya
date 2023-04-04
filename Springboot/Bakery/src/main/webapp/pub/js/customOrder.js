
let shape = document.getElementById("cakeShape");

shape.addEventListener("change", () => {
    let sizeOptions = document.getElementById("cakeSize");
    while(sizeOptions.firstChild) {
        sizeOptions.removeChild(sizeOptions.firstChild);
    }

    let index = shape.selectedIndex;

    if (index === 1) {
        let roundSizes = ['6"', '8"', '10"', '12"'];
        for (let size of roundSizes) {
            let round = document.createElement("option");
            round.innerHTML = size;
            sizeOptions.appendChild(round);
        }
    }

    if (index === 2) {
        let sheetSizes = ['1/4 Sheet Single', '1/4 Sheet Double', '1/2 Sheet Single',
            '1/2 Sheet Double', 'Full Sheet Single', 'Full Sheet Double'];
        for (let size of sheetSizes) {
            let sheet = document.createElement("option");
            sheet.innerHTML = size;
            sizeOptions.appendChild(sheet);
        }
    }
})



let submitBtn = document.getElementById("submitBtn");

submitBtn.addEventListener("click", () => {
    let nameInput = document.getElementById("name");
    let nameText = document.getElementById("nameHelp");
    checkName(nameInput, nameText);

    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    checkEmail(emailInput, emailText);

    let dateInput = document.getElementById("eventDate");
    let dateText = document.getElementById("dateHelp");
    checkEventDate(dateInput, dateText);
})

function checkName(nameInput, nameText) {
    let nameValue = nameInput.value;
    let msg = "";
    if (nameValue === "") {
        msg = "Please enter your name";
        markRed(nameInput, nameText, msg);
    } else if (!nameValue.match(/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/)) {
        msg = "Please enter a valid name containing only letters";
        markRed(nameInput, nameText, msg);
    } else {
        removeRed(nameInput, nameText);
    }
}

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

function checkEventDate(dateInput, dateText) {
    let dateValue = dateInput.value;
    let event = new Date(dateValue);
    let today = new Date();
    let diffTime = event - today;
    let diffDays = Math.ceil(diffTime / (24 * 60 * 60 * 1000));

    let msg = "";
    if (dateValue === "") {
        msg = "Please select a pickup date";
        markRed(dateInput, dateText, msg);
    } else if (diffDays < 14) {
        msg = "Minimum of 14 days notice";
        markRed(dateInput, dateText, msg);
    } else {
        removeRed(dateInput, dateText, msg)
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
    let nameInput = document.getElementById("name");
    let nameText = document.getElementById("nameHelp");
    reset(nameInput, nameText);

    let emailInput = document.getElementById("email");
    let emailText = document.getElementById("emailHelp");
    reset(emailInput, emailText);

    let dateInput = document.getElementById("eventDate");
    let dateText = document.getElementById("dateHelp");
    reset(dateInput, dateText);

})

function reset(input, text) {
    removeRed(input, text);
    input.value = "";
    text.innerHTML = "";
}

