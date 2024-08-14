// Arrary function
// 배열 조작 함수
let iveMembers = [
    '안유진',
    '장원영',
    '레이',
    '가을'
];
console.log(iveMembers);
// push() : iveMembers 끝에 '이서' 추가
iveMembers.push('이서');
console.log(iveMembers);
// pop() : 배열의 맨 뒤의 아이템 반환 -> 삭제
console.log(iveMembers.pop());
// 맨 앞에 추가
iveMembers.unshift('김형민');
console.log(iveMembers);
// 맨 앞에 자료 삭제
console.log(iveMembers.shift());
// splice(시작위치, 삭제할 item 수)
iveMembers.splice(0,2);
console.log(iveMembers);

iveMembers = [
    '안유진',
    '장원영',
    '레이',
    '가을',
    '이서'
];
console.log('---------------------')
// concat() : 새로운 Item을 맨 뒤에 삽입 단, 원본 수정 X
console.log(iveMembers.concat('김형민'));
// slice() : 삭제할 인덱스, 몇 인덱스 앞까지.... 원본수정 X
console.log(iveMembers.slice(0, 3))
console.log(iveMembers)

// spread operator(...) : 기존 배열을 몽땅 가져옴.
// 배열을 복사할 때 사용
let iveMemver2 = [...iveMembers];
console.log(iveMemver2);

// join() : 배열 자료를 ,(콤마)로 구분해서 문자열로 반환
let iveMemberString = iveMembers.join(' ');
console.log(iveMemberString);

// *** sort()
console.log('sort ---------------------')
iveMembers.sort();
console.log(iveMembers);

console.log('reverse sort ---------------------')
iveMembers.reverse();
console.log(iveMembers);

// *** sort() 확인...
let numbers = [11, 2, 1, 9, 3, 5];
console.log('number sort ---------------------')
//console.log(numbers.sort((a, b)=> a-b));
console.log(numbers.sort((a, b)=> a < b? 1 : -1));

let stringData = ['D', 'A', 'C', 'B'];
console.log('String sort ---------------------')
console.log(stringData.reverse());
console.log(stringData.sort((x, y)=> x < y? 1 : -1));

// *** map() : 원래 배열을 변형시켜 새로운 배열을 돌려 줌.
// (원본유지) -- mapping 
console.log('map ---------------------')
console.log(iveMembers.map((member)=> `아이브 : ${member}`));
console.log(iveMembers);

console.log('map(장원영이 모자씌우기) --------------')
let mapIve = iveMembers.map((x) => {
    if(x === '장원영'){
        return `모자쓴 ${x}`;
    } else {
        return x;
    }
})
console.log(mapIve);

// 정렬 후 안유진 모자씌우기
console.log(iveMembers.sort().map((x)=>{
    if(x === '안유진'){
        return `모자쓴 ${x}`;
    } else {
        return x;
    }
}));

// *** filter() : 원하는 자료만 선택적으로 가져오기
// 원본 수정 X
numbers = [11, 2, 1, 9, 3, 5];

console.log("짝수값만 출력하기 -------")
// console.log(numbers.filter((x) => {
//     // return (x % 2) == 0;
//     return x > 3;
// }))
console.log(numbers.filter((x)=> x > 3));
// 문제. 3보다 큰 수를 찾아서 오름차순 정렬하시오.
console.log(numbers.filter((x)=> x>3)
                   .sort((x, y)=> x<y? -1:1));

// 문제. 위 배열에서 가장 큰수와 가장 작은수를 찾아 출력하시요.  
let maxNumber = Number.MIN_VALUE;
let minNumber = Number.MAX_VALUE;
numbers = [11, 2, 1, 9, 3, 5];
for(let i=0; i < numbers.length ; i++){
    if(maxNumber < numbers[i]) maxNumber = numbers[i];
    if(minNumber > numbers[i]) minNumber = numbers[i];
}
console.log("maxNumber : " + maxNumber 
        + " ,minNumber : " +minNumber);





