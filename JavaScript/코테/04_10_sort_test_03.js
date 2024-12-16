let fs = require('fs');
let input = fs.readFileSync('sort_map.txt').toString().split('\n');

let n = parseInt(input[0]);
let data = input[1].split(' ').map(Number);
// set으로 중복 제거
let setData = [... new Set(data)];
// 오름차순 정렬 수행
setData.sort((a, b)=> a -b);

// 맵으로 저장
let myMap = new Map();
for(let i = 0; i < setData.length; i++){
    myMap.set(setData[i], i);
}

// data 를 출력하되 map에 매핑되어 있는 value 값 출력
let result = '';
for(x of data){
    result += myMap.get(x) + ' ';
}
console.log(result);