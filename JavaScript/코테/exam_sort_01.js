let fs = require('fs');
let input = fs.readFileSync('exam_sort_01.txt')
                .toString().split('\n');
// 전체 자료 개수를 n에 저장
let n = Number(input[0]);
// 신규 배열 생성
let data = [];
for(let i=1; i<=n; i++){
    let [x, y] = input[i].split(' ').map(Number);
    data.push([x, y]);
}                
console.log('소스 : ');
console.log(data);
// 정렬 진행
data.sort(compare);
function compare(a, b){
    if(a[0] != b[0]){
        return a[0] - b[0]; // x좌표 오름기준
    } else {
        return a[1] - b[1]; // 같다면 y좌표 기준
    }
}
console.log('결과 : ');
console.log(data);

let result = '';
// for(let item of data){
//     result = result + item[0] + ' ' + item[1] + '\n';
// }
for(let i=0; i<data.length; i++){
    let x = data[i];
    result = result + x[0] + ' ' + x[1] + '\n';
}
console.log(result);
