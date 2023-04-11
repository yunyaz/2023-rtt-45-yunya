// 4. Fibonacci

n = 4

/* output
0
1
1
2
*/


/*
 * Complete the 'fibonacci' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER n as parameter.
 */

function fibonacci(n) {
    // Write your code here
    const result = [];
    if (n == 1) {
        result.push(0);
        return result;
    }
    result.push(0);
    result.push(1);
    for (let i = 2; i < n; i++) {
        result.push(result[i - 1] + result[i - 2]);
    }
    return result;
}