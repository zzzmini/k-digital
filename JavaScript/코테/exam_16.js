// 36,000번 주사위 2개를 던져서 나온 합의 구성비

let diceSum = new Array(11).fill(0);
let dice_1 = 0;
let dice_2 = 0;

for(let i = 1; i <= 36000; i++){
    dice_1 = Math.floor((Math.random()*6)) + 1;
    dice_2 = Math.floor((Math.random()*6)) + 1;
    diceSum[dice_1 + dice_2 - 2] ++; 
}
// Output :
// 2 : 1026 (0.028500)
console.log('Output : ')
for(let i = 0; i < diceSum.length; i++){
    console.log(`${i+2} : ${diceSum[i]} (${(diceSum[i]/36000).toFixed(6)})`)
}