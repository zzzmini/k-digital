let fs = require("fs");
let input = fs.readFileSync('문제10_최대최소.txt').toString().split("\n");

let count = parseInt(input[0]);
let data = input[1].split(' ').map(x => Number(x));

console.log(`데이터 - ${data}`);

let max = data.reduce((a,b) => Math.max(a,b));
let min = data.reduce((a,b) => Math.min(a,b));
console.log(`max : ${max}, min : ${min}`);

