// 문제 4. 조건문 문제 : 시험성적문제
let fs = require('fs');
let input = fs.readFileSync('input_04.txt')
            .toString().split('\n');
let score = parseInt(input[0]);
let result = '';
if(score >= 90) {
    result = 'A';
} else if(score >= 80) {
    result = 'B';
} else if(score >= 70) {
    result = 'C';
} else if(score >= 60) {
    result = 'D';
} else result = 'F';

console.log(result);  
