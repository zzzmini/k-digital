// 1. 숫자 정렬
let data = [3,5,2,1,4];
console.log('source : ' + data);
data.sort((a,b)=> {
    if(a<b) return -1;
    if(a>b) return 1;
    if(a==b) return 0;
});

console.log('result : ' + data);

// 2. 문자의 정렬
let strData = ['findapple', 'durian', 'Carrot', 
                'banana', 'apple'];
console.log('source : ' + strData);
strData.sort((a,b)=> {
    if(a<b) return -1;
    if(a>b) return 1;
    if(a==b) return 0;
});

console.log('result : ' + strData);   

// 3. 문자의 정렬(대소문자 구분없이)
let strData2 = ['findapple', 'durian', 'Carrot', 
    'banana', 'apple'];
console.log('source : ' + strData2);
strData2.sort(compare);  // 함수의 이름만 적어요...

function compare(a, b){
    let upperA = a.toUpperCase();
    let upperB = b.toUpperCase();
    if(upperA<upperB) return -1;
    if(upperA>upperB) return 1;
    if(upperA==upperB) return 0;
}

console.log('result : ' + strData2);       

// 4. 객체 비교
let objectData = [
    {name : '홍길동', score : 90},
    {name : '김철수', score : 85},
    {name : '박영희', score : 99},
];
// 성적에 대한 내림차순으로 정렬하기(성적순)
for(man of objectData){
    console.log('source : ' + man.name + ' ' + 
        man.score);
}
objectData.sort(compareObject);

function compareObject(a, b){
    return b.score - a.score;
}

for(man of objectData){
    console.log('result : ' + man.name + ' ' + 
        man.score);
}
