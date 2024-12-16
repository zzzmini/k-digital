let fs = require('fs');
let input = fs.readFileSync('05_01_greedy_01.txt').toString().split('\n');

let n = Number(input[0].split(' ')[0]);  // 동전개수
let k = Number(input[0].split(' ')[1]);  // 만들 금액

let arr = [];
// 전체 동전 데이터 입력
for(let i=1; i<=n; i++){
    arr.push(Number(input[i]));
}
let cnt = 0;
for(let i = n-1; i>=0; i--){
    cnt += parseInt(k / arr[i]); // 해당동전 몇개 사용?
    k %= arr[i]; // 주고 남은 금액
}

console.log(cnt);