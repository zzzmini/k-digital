let fs = require("fs");
let input = fs.readFileSync('문제14_문자열반복.txt').toString().split("\n");

let n = Number(input[0]);
let data = [];

for(let i = 1; i <= n ; i++){
    let[repeat, str] = input[i].split(' ');
    let result = '';
    for(let j = 0; j < str.length; j++){
        result += str.charAt(j).repeat(repeat);
    }
    console.log(result);
}