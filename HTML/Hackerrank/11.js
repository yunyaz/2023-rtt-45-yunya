// 11. Area of Triangle

x = [0, 4, 7];
y = [0, 8, 6]; // output: 16

x = [0, 3, 6]
y = [0, 3, 0] // output: 9

x = [0, 1, 0]
y = [0, 0, 2] // output: 1

/*
 * Complete the 'getTriangleArea' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY x
 *  2. INTEGER_ARRAY y
 */

function getTriangleArea(x, y) {
    // Write your code here
    
    let side1 = Math.sqrt((x[0] - x[1]) ** 2 + (y[0] - y[1]) ** 2);
    let side2 = Math.sqrt((x[1] - x[2]) ** 2 + (y[1] - y[2]) ** 2);
    let side3 = Math.sqrt((x[2] - x[0]) ** 2 + (y[2] - y[0]) ** 2);
    
    let s = (side1 + side2 + side3) / 2;
    
    let area = Math.round(Math.sqrt(s * ((s - side1) * (s - side2) * (s - side3))));
    
    return area;

}