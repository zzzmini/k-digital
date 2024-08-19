let fs = require('fs');
let input = fs.readFileSync('sort.txt')
        .toString().split('\n');        
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);

for(let i=0; i<data.length - 1; i++){
    // 가장 작은 값의 인덱스를 넣어둘 변수
    let minIndex = i;
    for(let j=i+1; j<data.length; j++){
        if(data[minIndex] > data[j]){
            minIndex = j;
        }
    }
    let temp = data[i];
    data[i] = data[minIndex];
    data[minIndex] = temp;
    console.log((i+1)+'회전 : ' + data);
}
