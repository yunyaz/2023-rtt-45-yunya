// 21. Good Segment

badNumbers = [ 5, 4, 2, 15 ]
lower = 1;
upper = 10; // output: 5


badNumbers = [8, 6, 20, 12];
lower = 1;
upper = 30; // output: 10

badNumbers = [ 1, 2, 3, 4 ];
lower = 1;
upper = 4; // output: 0

goodSegment(badNumbers, lower, upper);

/*
 * Complete the 'goodSegment' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY badNumbers
 *  2. INTEGER lower
 *  3. INTEGER upper
 */

function goodSegment(badNumbers, lower, upper) {
    // Write your code here
    
    badNumbers.sort((a, b) => a - b);
    let result = 0;
    let length = 0;
    
    for (let i = 0; i < badNumbers.length; i++) {
        if (upper < badNumbers[i]) {
            length = upper - lower + 1;
        } else if (lower <= badNumbers[i]) {
            length = badNumbers[i] - lower;
            lower = badNumbers[i] + 1;
        }
        result = Math.max(result, length);
    }
    if (lower > badNumbers[badNumbers.length - 1]) {
        length = upper - lower + 1;
        result = Math.max(result, length);
    }
    return result;
}