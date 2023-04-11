// 5. Character Reprogramming

s = 'RRR' // output: 0
s = 'RUDRL' // output: 4

/*
 * Complete the 'getMaxDeletions' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

function getMaxDeletions(s) {
    // Write your code here
    const dir = {U:0, D:0, L:0, R:0};
    for (let i = 0; i < s.length; i++) {
        dir[s[i]]++;
    }
    let diff = Math.abs(dir.U - dir.D) + Math.abs(dir.L - dir.R);
    return s.length - diff;
}