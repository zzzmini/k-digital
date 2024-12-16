let fs = require("fs");
let input = fs.readFileSync('A+B.txt').toString().split("\n");
let data = input[0].split(' ');
let result = 0;
for(let i=0; i < data.length; i++){
  result += Number(data[i]);
}
console.log(result);