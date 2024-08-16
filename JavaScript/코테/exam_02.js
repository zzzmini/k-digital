// 문제 2. 두 정수 A와 B를 입력받은 다음, 
// 두 수 A와 B 사이의 모든 정수값을 더해
// 출력하는 프로그램을 작성하시오.
const fs = require('fs');
const input = fs.readFileSync('input_02.txt')
    .toString().split('\n');
let [startNum, endNum] = input[0].split(' ').map(Number);  
// 누적할 변수
let sum = 0;  

if(startNum > endNum) {
    let temp = startNum;
    startNum = endNum;
    endNum = temp;
}

for(let i = startNum; i <= endNum; i++){
    sum += i;  // sum = sum + i;
}
console.log(sum);
