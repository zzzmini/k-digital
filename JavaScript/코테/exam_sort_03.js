let fs = require('fs');
let input = fs.readFileSync('exam_sort_03.txt')
                .toString().split('\n');
// 전체 자료 개수를 n에 저장
let n = Number(input[0]);
// 신규 배열 생성
let data = input[1].split(' ').map(Number);    
console.log('소스 : ');
console.log(data);
// set 으로 변경 후 정렬
let setData = [... new Set(data)].sort((a,b)=> a-b);

console.log(setData);
// map으로 전환
let mapData = new Map();
// setData를 mapData로 변환
for(let i=0; i<setData.length; i++){
    mapData.set(setData[i], i);
}
// mapData 출력
// console.log(mapData);
for(let key of mapData.keys()){
    console.log('key = ' + key + ', value = '
             + mapData.get(key));
}


// data 배열을 순회하면서 mapData의 키와 매핑된 value값 출력
let result = '';
for(let x of data){
    result = result + mapData.get(x) + ' ';
}
console.log(result);