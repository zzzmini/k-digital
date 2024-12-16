let fs = require("fs");
let input = fs.readFileSync('문제13_평균조작.txt').toString().split("\n");

let n = Number(input[0]);
let scores = input[1].split(' ').map(Number);
let maxValue = scores.reduce((a, b)=>Math.max(a,b));
let updated = [];

for(let i = 0; i < n; i++){
    updated.push(scores[i] / maxValue * 100);
}

console.log(updated.reduce((a,b)=> a+b)/n);
