// 8. Price Check

products=['rice', 'sugar', 'wheat', 'cheese']
productPrices=[16.89, 56.92, 20.89, 345.99]
productSold =['rice', 'cheese']
soldPrice =[18.99, 400.89]  // output: 2

products=[chocolate, cheese, tomato]
productPrices=[15.00, 300.90, 23.44]
productSold=[chocolate, cheese, tomato]
soldPrice =[15, 300.90,10.00] // output: 1


/*
 * Complete the 'priceCheck' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING_ARRAY products
 *  2. FLOAT_ARRAY productPrices
 *  3. STRING_ARRAY productSold
 *  4. FLOAT_ARRAY soldPrice
 */

function priceCheck(products, productPrices, productSold, soldPrice) {
    // Write your code here
    
    let result = 0;
    let map = new Map();
    for (let i = 0; i < products.length; i++) {
        map.set(products[i], productPrices[i]);
    }
    for (let i = 0; i < productSold.length; i++) {
        if (map.get(productSold[i]) !== soldPrice[i]) {
            result++;
        }
    }
    return result;
}