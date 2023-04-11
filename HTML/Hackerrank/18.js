// 18. Array Challenge

arr = [2, 1, 3]; // output: 0 -1 3
arr = [1, 2, 2, 3]; // output: 0 1 1 4


/*
 * Complete the 'arrayChallenge' function below.
 *
 * The function is expected to return a LONG_INTEGER_ARRAY.
 * The function accepts LONG_INTEGER_ARRAY arr as parameter.
 */

function arrayChallenge(arr) {
    // Write your code here
    
    let result = [];
    result[0] = 0;
    for (let i = 1; i < arr.length; i++) {
        result[i] = i * (arr[i] - arr[i - 1]) + result[i - 1];
    }
    return result;
}