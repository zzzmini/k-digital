let fs = require('fs');
input = fs.readFileSync('sort.txt').toString().split('\n');
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
insertion(data);

function insertion(data){
    for(let i=1; i<data.length; i++){
        for(let j = i ; j > 0 ; j--){
            if(data[j] < data[j-1]){
                swap(j, j-1);
            }
            // 자기보다 작으면 멈춤
            else {
                break;
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