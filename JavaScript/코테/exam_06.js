// 문제 6. 오븐시계
// 주어진 시간 + 조리 시간 = 최종 완료 시간 출력
let fs = require('fs');
let input = fs.readFileSync('input_06.txt')
            .toString().split('\n');
let [hour, minute] = input[0].split(' ').map(Number);
console.log(hour + ' ' + minute);
let cookTime = Number(input[1]);

let totalTime = (hour * 60) + minute + cookTime;
console.log(totalTime);

hour = parseInt(totalTime / 60) % 24;
minute = totalTime % 60;

console.log(hour + ' ' + minute);