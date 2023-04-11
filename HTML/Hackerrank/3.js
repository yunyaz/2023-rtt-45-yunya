// 3. Programming Contest

ratings = [1, 3, 6, 6] // output: 2
ratings = [2, 4, 5, 3, 7, 8] // output: 3


/*
 * Complete the 'minimizeBias' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY ratings as parameter.
 */

function minimizeBias(ratings) {
    // Write your code here
    ratings.sort((a, b) => b - a);
    let bias = 0;
    for (let i = 0; i < ratings.length; i = i + 2) {
        bias += ratings[i] - ratings[i + 1];
    }
    return bias;

}