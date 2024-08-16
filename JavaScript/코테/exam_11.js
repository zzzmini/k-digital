// 문제 11. 최댓값과 인덱스찾기
let fs = require('fs');
let input = fs.readFileSync('input_11.txt')
            .toString().split('\n').map(Number);
// 가장 큰값
let maxNum = Number.MIN_VALUE;
let maxIndex = 0;
for(let i=0; i<input.length; i++){
    if(input[i] > maxNum){
        maxNum = input[i];
        maxIndex = i;
    }
}            
console.log(`max : ${maxNum}, index : ${maxIndex}`);    

let otherMax = Math.max(...input);
let otherIndex = input.indexOf(otherMax);
console.log(`otherMax : ${otherMax}, otherIndex : ${otherIndex}`);  