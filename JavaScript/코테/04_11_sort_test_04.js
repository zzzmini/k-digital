let fs = require('fs');
let input = fs.readFileSync('sort_num.txt').toString().split('\n');

let n = input[0];
let cnt = Array.from({length:10}, () => 0);
for(let x of n){
    cnt[Number(x)] ++;
}
console.log(cnt);
let result = '';
// 결과 출력 - cnt 배열에 든 수만큼 값 인쇄
// 단, 뒤에서 부터
for(let i = 9; i >= 0; i--){
    for(let j = 0; j < cnt[i]; j++){
        result += i + '';
    }
}
console.log(result);