// 20. Twin Strings 

a = ["cdab", "dcba", "abcd"]; // output: Yes No No
b = ["abcd", "abcd", "abcdcd"]; // output: Yes Yes

/*
 * Complete the 'twins' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING_ARRAY a
 *  2. STRING_ARRAY b
 */

function twins(a, b) {
    // Write your code here
    
    let result = [];
    const yes = "Yes";
    const no = "No"
    for (let i = 0; i < a.length; i++) {
        if (a[i] === b[i]) {
            result.push(yes);
        } else if (a[i].length !== b[i].length) {
            result.push(no);
        } else {
            let aEven = [];
            let bEven = [];
            for (let j = 0; j < a[i].length; j += 2) {
                aEven.push(a[i].charAt(j));
                bEven.push(b[i].charAt(j));
            }
            let aOdd = [];
            let bOdd = [];
            for (let j = 1; j < a[i].length; j += 2) {
                aOdd.push(a[i].charAt(j));
                bOdd.push(b[i].charAt(j));
            }
            if (aEven.sort().join() === bEven.sort().join() 
                    && aOdd.sort().join() === bOdd.sort().join()) {
                result.push(yes);
            } else {
                result.push(no);
            }
        }
    }
    return result;

}