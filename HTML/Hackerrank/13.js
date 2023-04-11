// 13. Two Strings

a = ['hello', 'hi']
b = ['world', 'bye']

/*
i a[i] 	b[i] 	Common 	Output
0 hello world 	o, l 	YES
1 hi 	bye 		    NO
*/


/*
 * Complete the 'commonSubstring' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY a
 *  2. STRING_ARRAY b
 */

function commonSubstring(a, b) {
    // Write your code here
    for (let i = 0; i < a.length; i++) {
        let set = new Set();
        let result = "NO";
        for (let j = 0; j < a[i].length; j++) {
            set.add(a[i].charAt(j));
        }
        for (let j = 0; j < b[i].length; j++) {
            if (set.has(b[i].charAt(j))) {
                result = "YES";
                break;
            }
        }
        console.log(result);
    }
}