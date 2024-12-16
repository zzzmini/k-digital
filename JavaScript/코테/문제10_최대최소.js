let fs = require("fs");
let input = fs.readFileSync('문제10_최대최소.txt').toString().split("\n");

let count = parseInt(input[0]);
let data = input[1].toString().split(' ');

console.log(`데이터 - ${data}`);

let max = -1000001;
let min = 1000001;
for(let i=0; i<data.length; i++){
    if(parseInt(data[i]) > max) max = parseInt(data[i]);
    if(parseInt(data[i]) < min) min = parseInt(data[i]);
}
console.log(`max : ${max}, min : ${min}`);

