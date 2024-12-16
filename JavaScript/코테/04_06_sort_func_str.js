let data = ['fineapple', 'durian', 'Carrot', 'banana', 'apple'];
console.log('source = ' + data);
data.sort();
console.log('result(asc) = ' + data);

data.sort(compare);
console.log('result(desc) = ' + data);

function compare(a,b){
    let upperA = a.toUpperCase();
    let upperB = b.toUpperCase();
    if(upperA>upperB) return -1;
    if(upperA<upperB) return 1;
    else return 0;
}