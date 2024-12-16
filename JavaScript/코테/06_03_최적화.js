let fs = require('fs');
let input = fs.readFileSync('06_03_최적화.txt').toString().split('\n');

console.log(input);
let n = parseInt(input[0]);
let arr = input[1].split(' ').map(Number);
let m = Number(input[2]);

let start = 1;
let end = arr.reduce((a, b) => Math.max(a, b));

let result = 0;
while(start <= end){
    let mid = parseInt((start + end) / 2);
    let total = 0;
    for(let x of arr){
        total += Math.min(x, mid); // 지방예산과 중간값을 비교 작은 값 선택
    }
    if(total <= m){
        result = mid;
        start = mid + 1;
    } else {
        end = mid - 1;
    }
}
console.log(result);