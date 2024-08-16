// 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 
// 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.

// ⓐ 같은 눈이 3개가 나오면 
//     -- 상금 : 10,000원 + (같은 눈) × 1,000원
// ⓑ 같은 눈이 2개만 나오는 경우에는 
//     -- 상금 : 1,000원 + (같은 눈) × 100원
// ⓒ 모두 다른 눈이 나오는 경우에는 
//     -- 상금 : (그 중 가장 큰 눈) × 100원
// 첫째, 같은 눈이 몇 개(같은 눈 : 3 또는 1)
// 둘째, 같은 눈의 주사위 수
// 셋째, 가장 큰 눈을 찾아야...
let fs = require('fs');
let input = fs.readFileSync('input_07.txt')
            .toString().split('\n');
let dice = input[0].split(' ').map(Number);

// 가장 큰 수 구하기
let maxNumber = Math.max(...dice);
// 중복 수의 갯수
let sameNumCount = 0;
// 중복 주사위 값
let sameNumber = 0;
// 지급 상금 변수
let money = 0;

// for 루프 돌리면서 각 값을 찾는다.
for(let i = 0; i < dice.length -1; i++){
    for(let j = i+1; j < dice.length; j++){
        if(dice[i] == dice[j]){
            sameNumCount ++;
            sameNumber = dice[i];
        }
    }
}
// 중복에 따른 보상 금액 구하기

if(sameNumCount >= 2){
    // 3개 중복 : 상금 : 10,000원 + (같은 눈) × 1,000원
    money = 10000 + (sameNumber * 1000);
} else if(sameNumCount == 1){
    // 2개 중복인 경우 : 상금 : 1,000원 + (같은 눈) × 100원
    money = 1000 + (sameNumber * 100);
} else {
    // 모두 다른경우
    // 상금 : (그 중 가장 큰 눈) × 100원
    money = maxNumber * 100;
}


console.log(money);