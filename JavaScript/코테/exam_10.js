// 문제 10. 최대, 최소구하기(reduce 함수 사용 금지)
let fs = require('fs');
let input = fs.readFileSync('input_10.txt')
            .toString().split('\n');

let count = Number(input[0]);
let data = input[1].split(' ').map(Number);
console.log(count + ' : ' + data )

let maxNum = Number.MIN_VALUE;
let minNum = Number.MAX_VALUE;

for(let i=0; i < count; i++){
    if(data[i] > maxNum) maxNum = data[i];
    if(data[i] < minNum) minNum = data[i];
}

console.log(`max : ${maxNum}, min : ${minNum}`);
// reduce 로 해결
reduceMaxNum = data.reduce((x, y)=> Math.max(x, y));
reduceMinNum = data.reduce((x, y)=> Math.min(x, y));
console.log(`reduceMaxNum : ${reduceMaxNum}, reduceMinNum : ${reduceMinNum}`);