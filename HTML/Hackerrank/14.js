// 14. Minimum Moves

arr1 = [1234, 4321]
arr2 = [2345, 3214] // output: 10

arr1 = [2468]
arr2 = [8642] // output: 16

/*
 * Complete the 'minimumMoves' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr1
 *  2. INTEGER_ARRAY arr2
 */

function minimumMoves(arr1, arr2) {
    // Write your code here
    let digit1 = 0;
    let digit2 = 0;
    let moves = 0;
    for (let i = 0; i < arr1.length; i++) {
        while (arr1[i] > 0) {
            digit1 = arr1[i] % 10;
            digit2 = arr2[i] % 10;
            moves += Math.abs(digit1 - digit2);
            
            arr1[i] = Math.trunc(arr1[i] / 10);
            arr2[i] = Math.trunc(arr2[i] / 10);
        }
    }
    return moves;
}