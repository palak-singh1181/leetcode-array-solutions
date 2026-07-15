function chunk(arr, size) {

    let result = [];

    for (let i = 0; i < arr.length; i += size) {
        result.push(arr.slice(i, i + size));
    }

    return result;
}

// Example
let arr = [1, 9, 6, 3, 2];

console.log(chunk(arr, 3));