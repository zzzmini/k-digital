let fs = require("fs");
let input = fs.readFileSync('문제7_주사위세개.txt').toString().split("\n");

let dice = input[0].toString().split(' ');
let money = 0;
let same = 0;
let sameNum = 0;
let maxNum = dice.reduce((a,b) => Math.max(a,b));

console.log(`주사위 - ${dice}`);

for(let i=0; i <  dice.length - 1; i++){
    for(let j=i+1 ; j < dice.length; j++){
        if(dice[i] == dice[j]) {
            same++;
            sameNum = dice[i];
        }
    }
}

if(same >= 2){
    money = 10000 + sameNum * 1000;
} else if(same == 1) {
    money = 1000 + sameNum * 100;
} else {
    money = maxNum * 100;
}

console.log('상금 - ' + money);