// 15. Maximizing the Final Element

arr = [1, 3, 2, 2]; // output: 3
arr = [3, 2, 3, 5]; // output: 4


/*
 * Complete the 'getMaxValue' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

function getMaxValue(arr) {
    arr.sort((a, b) => a - b);
    arr[0] = 1;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] - arr[i - 1] > 1) {
            arr[i] = arr[i - 1] + 1;
        }
    }
    return arr[arr.length - 1];
}