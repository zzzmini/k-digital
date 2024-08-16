// 문제 12. 평균은 넘겠지?
// 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 
// 소수점 셋째 자리까지 출력한다. 
let fs = require('fs');
let input = fs.readFileSync('input_12.txt')
            .toString().split('\n');
let rowCount = Number(input[0]);

for(let i = 1; i <= rowCount; i++){
    let data = input[i].split(' ').map(Number);
    let dataSize = data[0];
    let sum = 0;
    let count = 0;
    for(let j = 1; j <= dataSize; j++){
        sum = sum + data[j];
    }
    let avg = sum / dataSize;
    for(let k = 1; k <= dataSize; k++){
        if(data[k] > avg) count = count + 1;
    }
    console.log(((count/dataSize)*100).toFixed(3) + '%');
}