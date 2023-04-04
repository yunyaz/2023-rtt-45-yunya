let numbers = [1, 3, 3, 4, 4, 4];

let result = 0;
    let map = new Map();
    for (let num of numbers) {
        if (map.get(num) === undefined) {
            map.set(num, 1);
        } else {
            map.set(num, map.get(num) + 1);
        }
    }
    console.log(map);
    for (let [key, value] of map.entries()) {
        console.log(value);
        if (value !== 1) {
            result++;
        }
    }
console.log(result);