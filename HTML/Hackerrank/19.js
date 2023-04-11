// 19. Chairs Requirement

simulations = ["CCRUCL","CRUC","CCCC"]; // output: 3 2 3

simulations = ["CCCRRR","CC","CCRURC"]; // output: 3 2 2

/*
 * Complete the 'minChairs' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY simulations as parameter.
 */

function minChairs(simulations) {
    // Write your code here
    const result = [];
    for (let i = 0; i < simulations.length; i++) {
        let purchase = 0;
        let available = 0;
        for (let j = 0; j < simulations[i].length; j++) {
            let ch = simulations[i].charAt(j);
            if (ch === "C" || ch === "U") {
                if (available === 0) {
                    purchase++;
                } else {
                    available--;
                }
            } else {
                available++;
            }
        }
        result.push(purchase);
    }
    return result;
}
