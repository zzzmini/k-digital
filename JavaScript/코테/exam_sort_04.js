let fs = require('fs');
let input = fs.readFileSync('exam_sort_04.txt')
                .toString().split('\n');
// 신규 배열 생성
let data = input[0].split('').map(Number);    
console.log('소스 : ');
console.log(data);
// 각 요소의 수를 측정할 배열을 선언
let count = Array(10).fill(0);

// data를 순회하면서 count 요소에 더하기
for(let i=0; i<data.length; i++){
    count[data[i]]++;
}
console.log(count);
let result = '';
// count 배열을 뒤에서 인덱스를 갯수만큼 출력
for(let i=9; i>=0; i--){
    for(let j=0; j<count[i]; j++){
        result = result + i + '';
    }
}
console.log(result);