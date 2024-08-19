let fs = require('fs');
let input = fs.readFileSync('sort.txt')
        .toString().split('\n');        
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
let flag = true;
for(let i=0; i<data.length-1; i++){
    // 교환이 일어났는지 확인할 변수
    flag = true;
    for(let j=0; j<data.length-i; j++){
        if(data[j] > data[j+1]){
            // 앞에 값이 클 때 바꿈
            let temp = data[j];
            data[j] = data[j+1];
            data[j+1] = temp
            // 교환 후 교환확인 변수 변경
            flag = false;
        }
    }
    if(flag == false) {
        console.log((i+1)+'회전 : ' + data);
    } else return;
}
console.log('정렬 완료');