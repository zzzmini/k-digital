// Array Function
let iveMembers = [
  '안유진',
  '가을',
  '레이',
  '장원영',
  '리즈',
  '이서'
];

console.log(iveMembers);

// ① push() : Array 맨 끝에 새로운 item추가(array 직접 변경)
iveMembers.push('An Yu Jin');
console.log(iveMembers);
// push()는 삽입 후 전체 추가된 것 포함한 배열의 길이를 반환한다.
console.log(iveMembers.push('Jang Won Young'));

// ② pop() : Array 맨 마지막 item 반환 → 삭제
console.log(iveMembers.pop());
console.log(iveMembers);

// ③ shift() : Array 맨 첫번째 값을 반환받고 삭제
console.log(iveMembers.shift());
console.log(iveMembers);

// ④ unshift()는 맨 앞에 추가한 후 push()와 같은 값을 리턴한다.
console.log(iveMembers.unshift('안유진'));
console.log(iveMembers);

// ⑤ splice(시작위치, 삭제할 item 수)
iveMembers.splice(0 ,3);
console.log(iveMembers);


/**
 * 기존 정의한 원본 데이터가 직접 변경되는 것은 자료처리상 상당히 위험한 부분이다.
 * 가급적 원본을 건드리지 않고 함수를 통해 변형 한 후
 * 원하는 결과를 얻어 사용하는 것이 바람직하다.
 */

// 원본을 변형하지 않는 함수.

// 배열 리셋

iveMembers = [
  '안유진',
  '가을',
  '레이',
  '장원영',
  '리즈',
  '이서'
];

// ⑥ concat() :  새로운 item을 배열 맨 뒤에 삽입하나, 원본은 수정되지 않는다.
console.log(iveMembers.concat('An Yu Jin'));
console.log(iveMembers);

// ⑦ slice(삭제할 시작인덱스, 몇 인덱스 전까지) : 원본은 수정되지 않는다.
console.log(iveMembers.slice(0, 3));
console.log(iveMembers);

// ⑧ spread operator (...) : 기존 배열을 펼쳐서 처리함.
let iveMembers2 = [...iveMembers];
console.log('iveMembers2 : ' + iveMembers2); // 기존 배열을 펼쳐서 복사 함.

// 배열안에 배열 넣기
let iveMembers3 = [iveMembers];
console.log(iveMembers3);

let iveMembers4 = iveMembers;
console.log(iveMembers4 === iveMembers);

// ⑨ join() : 배열 내 자료를 ,(comma)로 구분한 후 문자열 형태로 반환
console.log(iveMembers.join());
console.log(typeof iveMembers.join());

// 구분자 주어서 출력하기
console.log(iveMembers.join('/'));

// ⑩ sort() : 오름차순 정렬하며 반환값 없고, 원본수정함.
console.log('sort -------------------')
iveMembers.sort();
console.log(iveMembers);

// ⑩ sort() : 역순 정렬하며 반환값 없고, 원본수정함.
console.log('reverse -------------------')
iveMembers.reverse();
console.log(iveMembers);

// sort() 함수로 오름차순, 내림차순 정렬하기
console.log('sort Asc/Desc-------------------')
let numbers = [
  1,
  9,
  7,
  5,
  3,
];

console.log(numbers);
// Ascending Sort
numbers.sort((a,b)=>{
  return a>b ? 1 : -1;
});
console.log(numbers);

// Descending Sort
numbers.sort((a,b)=>{
  return a>b ? -1 : 1;
});
console.log(numbers);

// ⑫ map() : 원래 배열을 변형시켜 새로운 배열을 돌려 줌(원본 유지)
console.log('map -------------------')
console.log(iveMembers.map((x)=> x));
console.log(iveMembers.map((x)=> `아이브 : ${x}`));
console.log(iveMembers);

// 안유진에게만 아이브 : 안유진으로 출력하기
console.log(iveMembers.map((x)=>{
  if(x === '안유진'){
    return `아이브 : ${x}`
  } else {
    return x;
  }
}));

// ⑬ filter()
console.log('filter -------------------')

numbers = [
  1,
  9,
  8,
  5,
  3,
];
console.log('전체 : ' + numbers.filter((x)=> true));
// 짝수만 출력하기
console.log('짝수 : ' + numbers.filter((x)=> x % 2 === 0));
// 3보다 큰 수 출력하기
console.log('3보다 큰수 : ' + numbers.filter((x)=> x > 3));

// 3보다 큰 수 찾아서 오름차순 정렬하기
console.log('3보다 큰 수 찾아서 오름차순 정렬하기 : ' + 
      numbers.filter((x) => x>3).sort((a,b) => a>b ? 1 : -1));

// ⑭ find() : 해당하는 첫번째 값 반환
//   findIndex() : 해당하는 인덱스 반환 
console.log('find -------------------');
console.log(numbers.find((x) => x % 2 === 0));
console.log(numbers.findIndex((x) => x % 2 === 0));

// ⑮ reduce() : 배열을 순회하면서 특정 기능을 처리
// reduce((p, n) => p+n, 0));
// p : previous, n : next, 0 : 첫 로딩 때 privious 값
console.log('reduce -------------------');

// reduce() 함수를 이용해서 배열의 합 구하기
console.log(numbers.reduce((p, n)=> p + n, 0));
      