let fs = require("fs");
let input = fs.readFileSync('문제11_최대값인덱스.txt').toString().split("\n");

let data = input.map(x => Number(x));
let index = 0;
let max = 0;
console.log(`데이터 - ${data}`);

// max = data.reduce((a,b)=>Math.max(a,b));
max = Math.max(...data)
index = data.indexOf(max);

// for(let i = 0; i < data.length; i++){
//     if(data[i] > max){
//         max = data[i];
//         index = i;
//     }
// }

console.log(`max : ${max}, min : ${index + 1}`);

