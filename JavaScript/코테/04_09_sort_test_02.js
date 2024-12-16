let fs = require('fs');
let input = fs.readFileSync('sort_word.txt').toString().split('\n');

let n = parseInt(input[0]);
let data = [];
for(let i = 1; i <= n; i++){
    data.push(input[i]);
}
console.log(data.length);
// 중복항목 제거위해 set으로 변환 후 배열로 되돌리기
data = [... new Set(data)];
// 정렬
data.sort((a,b)=>{
    // 길이가 같으면 짧은 것 부터
    if(a.length != b.length) return a.length - b.length;
    else {
        // 길이가 같으면 사전 순으로
        if(a < b) return -1;
        if(a > b) return 1;
        else return 0;
    }
})

// 하나씩 출력
for(let x of data){
    console.log(x);
}