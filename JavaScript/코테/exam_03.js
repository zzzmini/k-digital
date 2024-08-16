// 문제 3. 곱셈문제

// (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.

//                  4 7 2   ---- (1)
//               ×  3 8 5   ---- (2)
//          --------------- 
//                2 3 6 0   ---- (3)
//              3 7 7 6     ---- (4)
//            1 4 1 6       ---- (5)
//         ---------------
//            1 8 1 7 2 0   ---- (6)
let fs = require('fs');
let input = fs.readFileSync('input_03.txt')
            .toString().split('\n');
console.log(input);  

let x = input[1].split('').map(Number);

for(let i=x.length-1; i>=0; i--){
    console.log(input[0] * x[i]);
} 
console.log(Number(input[0]) * Number(input[1]));