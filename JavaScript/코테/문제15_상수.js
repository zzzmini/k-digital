let fs = require("fs");
let input = fs.readFileSync('문제15_상수.txt').toString().split("\n");

data = input[0].toString().split(' ');
let x = data[0];
let y = data[1];

let newX = x[2] + x[1] + x[0];
let newY = y[2] + y[1] + y[0];

console.log(Math.max(Number(newX), Number(newY)));