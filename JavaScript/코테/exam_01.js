let fs = require('fs');
let input = fs.readFileSync('input_01.txt')
            .toString().split('\n');


let data = input[0].split(' ').map(Number);
console.log(data.reduce((x,y)=> x+y));            