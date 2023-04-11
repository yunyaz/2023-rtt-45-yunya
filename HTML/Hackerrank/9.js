// 9. Count Duplicate Elements

numbers = [1, 3, 1, 4, 5, 6, 3, 2] // output: 2
numbers = [1, 1, 2, 2, 2, 3] // output: 2

/*
 * Complete the 'countDuplicate' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY numbers as parameter.
 */

function countDuplicate(numbers) {
    // Write your code here
    
    let result = 0;
    let map = new Map();
    for (let num of numbers) {
        if (map.get(num) === undefined) {
            map.set(num, 1);
        } else {
            map.set(num, map.get(num) + 1);
        }
    }
   
    for (let [key, value] of map) {
        if (value !== 1) {
            result++;
        }
    }
    return result;
}
