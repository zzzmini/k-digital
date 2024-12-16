let fs = require('fs');
input = fs.readFileSync('sort.txt').toString().split('\n');
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
for(let i=0; i<data.length-1; i++){
    let minIndex = i;
    for(let j=i+1; j<data.length; j++){
        if(data[minIndex] > data[j]){
            minIndex = j;
        }
    }
    
    swap(i, minIndex);
    console.log((i+1) + '회전 : ' + data);
}

function swap(i, minIndex){
    let temp = data[i];
    data[i] = data[minIndex];
    data[minIndex] = temp;
}