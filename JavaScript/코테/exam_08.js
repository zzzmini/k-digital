// 문제 8. 입력받은 구구단 출력하기
let fs = require('fs');
let input = fs.readFileSync('input_08.txt')
            .toString().split('\n');
let dan = Number(input[0]);

for(let i=1; i<=9; i++){
    console.log(`${dan} * ${i} = ${dan*i}`)
}