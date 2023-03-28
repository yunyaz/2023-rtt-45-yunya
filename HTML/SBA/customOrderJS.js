let shape = document.getElementById("cakeShape");

shape.addEventListener("change", () => {
    let sizeOptions = document.getElementById("cakeSize");
    while(sizeOptions.firstChild) {
        sizeOptions.removeChild(sizeOptions.firstChild);
    }

    let index = shape.selectedIndex;

    if (index === 1) {
        let roundSizes = ['6"', '8"', '10"', '12"'];
        for (size of roundSizes) {
            let round = document.createElement("option");
            round.innerHTML = size;
            sizeOptions.appendChild(round);
        }
    }

    if (index === 2 ) {
        let sheetSizes = ['1/4 Sheet Single', '1/4 Sheet Double', '1/2 Sheet Single', 
                            '1/2 Sheet Double', 'Full Sheet Single', 'Full Sheet Double'];
        for (size of sheetSizes) {
            let sheet = document.createElement("option");
            sheet.innerHTML = size;
            sizeOptions.appendChild(sheet);
        }
    }
})