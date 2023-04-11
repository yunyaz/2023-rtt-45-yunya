// 16. Tool List

tools = ['ballendmill', 'facemill', 'keywaycutter', 'slotdrill']; // output: 2
tools = ['facemill', 'slotdrill', 'ballendmill', 'ballendmill']; // output: 1

/*
 * Complete the 'toolchanger' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING_ARRAY tools
 *  2. INTEGER startIndex
 *  3. STRING target
 */

function toolchanger(tools, startIndex, target) {
    // Write your code here
    let min = tools.length;
    let diff = 0;
    for (let i = 0; i < tools.length; i++) {
        if (tools[i] === target) {
            diff = Math.abs(i - startIndex);
            if (diff > Math.trunc(tools.length / 2)) {
                diff = tools.length - diff;
            }
            min = Math.min(diff, min);
        }
    }
    return min;
}
