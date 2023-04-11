// 6. Complementing a DNA Strand


s = "ACCGGGTTTT" // output: AAAACCCGGT
s = "ATGC" // output: GCAT
s = "ATCGTA" // output: TACGAT


/*
 * Complete the 'dnaComplement' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

function dnaComplement(s) {
    // Write your code here
    let sReverse = s.split("").reverse().join("");
    let result = "";
    for (let i = 0; i < s.length; i++) {
        if (sReverse.charAt(i) === 'A') {
            result += 'T';
        } else if (sReverse.charAt(i) === 'T') {
            result += 'A';
        } else if (sReverse.charAt(i) === 'C') {
            result += 'G';
        } else {
            result += 'C';
        }
    }
    return result;
}