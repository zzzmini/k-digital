// 문제 15. 값을 거꾸로 읽어서 큰 수 찾기
// 734 893

let fs = require('fs');
let input = fs.readFileSync('input_15.txt')
            .toString().split('\n');
data = input[0].toString().split(' ');
let newX = '';
let newY = '';

for(let i = 2; i >=0; i--){
    newX = newX + data[0].charAt(i);
    newY = newY + data[1].charAt(i);
}    
console.log(Math.max(Number(newX), Number(newY))); 