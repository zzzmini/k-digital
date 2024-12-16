let fs = require("fs");
let input = fs.readFileSync('문제6_오븐시계.txt').toString().split("\n");

let clock = input[0].toString().split(' ');

// let hour = parseInt(clock[0]);
// let minute = parseInt(clock[1]);
let [hour, minute] = input[0].split(' ').map(Number);
let time = Number(input[1].toString().split(' '));

console.log(`현재시간 - ${hour} : ${minute} ,요리시간 - ${time}`);

totalTime = (hour * 60) + minute + time;

hour = (parseInt(totalTime / 60)) % 24;
minute = totalTime % 60;

console.log(hour + ' ' + minute);