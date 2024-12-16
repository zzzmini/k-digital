let fs = require("fs");
let input = fs.readFileSync('문제12_평균.txt').toString().split("\n");

let rowCount = Number(input[0]);

for(let i = 1; i <= rowCount; i++){
    let data = input[i].split(' ').map(Number);
    let n = data[0];
    let sum = 0;
    for(let j=1; j<=n; j++){
        sum += data[j];
    }
    let avg = sum / n;
    let cnt = 0;
    for(let k=1; k<=n; k++){
        if(data[k] > avg) cnt += 1;
    }
    console.log(`${(cnt/n*100).toFixed(3)}%`)
}

