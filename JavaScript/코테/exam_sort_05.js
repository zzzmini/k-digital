let fs = require('fs');
let input = fs.readFileSync('exam_sort_05.txt')
                .toString().split('\n');
console.log(input);
// 돈의 단위 갯수와 금액을 나눠서 담는다.
let [num, totoalMoney] = input[0].split(' ').map(Number);
console.log(num + ' , ' + totoalMoney);
// 돈의 단위를 배열에 담는다.
let don = [];
for(let i = 1; i <= num; i++){
    don[i-1] = Number(input[i]);
}
console.log('소스 : ');
console.log(don);

//동전갯수를 셀 변수
let count = 0;
// 바꿔줄 동전의 갯수 계산
for(let i=num-1; i>=0; i--){
    count = count + parseInt(totoalMoney / don[i]);
    totoalMoney = totoalMoney % don[i];
}
console.log(count);