let fs = require('fs');
let input = fs.readFileSync('sort.txt')
        .toString().split('\n');        
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
for(let i=1; i<data.length; i++){
    for(let j=i; j>0; j--){
        if(data[j] < data[j-1]){
            // 교환
            let temp = data[j];
            data[j] = data[j-1];
            data[j-1] = temp;
        } else break;
    }
    console.log((i+1) + '회전 : ' + data);
}