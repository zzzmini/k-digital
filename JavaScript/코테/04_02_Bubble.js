let fs = require('fs');
input = fs.readFileSync('sort.txt').toString().split('\n');
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
bubble(data);

function bubble(data){
    for(let i=0; i<data.length-1; i++){
        for(let j = 0 ; j<data.length -i ; j++){
            if(data[j] > data[j+1]){
                swap(j, j+1);
            }
        }
        console.log((i+1) + '회전 : ' + data);
    }
}

function swap(i, j){
    let temp = data[i];
    data[i] = data[j];
    data[j] = temp;
}