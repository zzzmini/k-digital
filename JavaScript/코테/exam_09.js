// 문제 9. 별
let fs = require('fs');
let input = fs.readFileSync('input_09.txt')
            .toString().split('\n');
let starNumber = Number(input[0]);

let star = '';

for(let i = 1; i <= starNumber; i++){
    for(let j = 1; j <= i; j ++){
        star = star + '*';
    }
    star = star + '\n';
}
console.log(star)