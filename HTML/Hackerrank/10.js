// 10. Minimum Amount

prices = [4, 9, 2, 3] // output: 10
prices = [1, 2, 3, 4] // output: 7

/*
 * Complete the 'calculateAmount' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts INTEGER_ARRAY prices as parameter.
 */

function calculateAmount(prices) {
    // Write your code here
    let lowestMarkedPrice = prices[0];
    let result = prices[0];
    for (let price of prices) {
        result += Math.max(price - lowestMarkedPrice, 0);
        lowestMarkedPrice = Math.min(lowestMarkedPrice, price);
    }
    return result;
}