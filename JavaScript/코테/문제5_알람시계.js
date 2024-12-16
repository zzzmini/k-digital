let fs = require("fs");
let input = fs.readFileSync('문제5_알람시계.txt').toString().split("\n");

let time = input.toString().split(' ');

let hour = parseInt(time[0]);
let minute = parseInt(time[1]);

console.log(time);

if(minute >= 45){
    minute = minute - 45;
} else if(hour > 0 && minute <= 45){
    hour = hour - 1;
    minute = minute + 15;
} else if(hour == 0 && minute <= 45){
    hour = 23;
    minute = minute + 15;
}
console.log(hour + ' ' + minute)