let fs = require('fs');
input = fs.readFileSync('sort.txt').toString().split('\n');
let data = input[0].split(' ').map(Number);
console.log('source = ' + data);
data.sort((a, b)=> a-b);
console.log('result(asc) = ' + data);

data.sort((a, b)=> b-a);
console.log('result(desc) = ' + data);