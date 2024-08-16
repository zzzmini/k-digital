// 문제 5. 알람시계문제
// 바로 "45분 일찍 알람 설정하기"이다..
// 10 10 --> 09 25
// 0 30  --> 23 45
let fs = require('fs');
let input = fs.readFileSync('input_05.txt')
            .toString().split('\n');
let [hour, minute] = input[0].split(' ').map(Number);

if(minute >= 45){
    minute = minute - 45;
} else if(hour > 0 && minute < 45){
    hour = hour - 1;
    minute = minute + 15;
} else if(hour == 0 && minute < 45){
    hour = 23;
    minute = minute + 15;
}

console.log(hour + ' ' +minute);


