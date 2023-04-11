// 7. Alphabetically Smallest String Builder

substrings = ['c', 'cc', 'cca', 'cccb']; // output: 'ccacccbccc'
substrings = ['a', 'bc', 'ad'] // output: 'aadbc'
substrings = ['abc', 'ab', 'bc'] // output:'ababcbc'
substrings = ['dd', 'dda', 'ddb'] // output: 'ddaddbdd'

/*
 * Complete the 'smallestString' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY substrings as parameter.
 */

function smallestString(substrings) {
    // Write your code here
    for (let i = 0; i < substrings.length; i++) {
        for (let j = i + 1; j < substrings.length; j++) {
            if (substrings[i] + substrings[j] > substrings[j] + substrings[i]) {
                let temp = substrings[i];
                substrings[i] = substrings[j];
                substrings[j] = temp; 
            }
        }
    }
    return substrings.join("");
}