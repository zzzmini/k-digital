let fs = require('fs');
let input = fs.readFileSync('sort_test.txt').toString().split('\n');

let n = Number(input[0]);
let data = [];

for(let i=1; i<=n; i++){
    let [x, y] = input[i].split(' ').map(Number);
    data.push([x, y]);
}
console.log('소스 : ');
console.log(data);

data.sort((a, b)=>{
        if(a[0] != b[0]){
        return a[0] - b[0]; // x 좌표 기준 오름차순
    } else {
        return a[1] - b[1]; // y 좌표 기준 오름차순
    }
})

// data.sort(compare);
// function compare(a, b){
//     if(a[0] != b[0]){
//         return a[0] - b[0]; // x 좌표 기준 오름차순
//     } else {
//         return a[1] - b[1]; // y 좌표 기준 오름차순
//     }
// }

console.log('결과 : ');
console.log(data);
console.log('출력 : ');

let result = '';
for(let item of data){
    result += item[0] + ' ' + item[1] + '\n';
}
console.log(result);