// ① object의 생성
console.log('① object의 생성 ---------')
let yuJin = {
  name : '안유진',
  group : '아이브',
  dance : function(){
    return '안유진이 춤을 춥니다.';
  }
};

console.log(yuJin);
console.log(yuJin.name);
console.log(yuJin['group']);

const key = 'name';
console.log(yuJin[key]);

console.log(yuJin.dance());

// ② 변수로 선언된 값으로 객체 생성하기
console.log('② 변수로 선언된 값으로 객체 생성하기---------')
const nameKey = 'name';
const nameValue = '안유진';
const groupKey = 'group';
const groupValue = 'IVE';
const yuJin2 = {
  [nameKey] : nameValue,
  [groupKey] : groupValue,
}
console.log(yuJin2);

// ③ 변수 수정 및 새로운 key : value 추가하기
console.log('③ 변수 수정 및 새로운 key : value 추가하기---------')
yuJin2['name'] = '민지'
yuJin2['group'] = '뉴진스';
console.log(yuJin2);
yuJin2.englishName = 'Min Ji';
console.log(yuJin2);
console.log('③ 삭제하기---------')
delete yuJin2.englishName;
console.log(yuJin2);

// ④ 객체의 특징
console.log('④ 객체의 특징--------------')
const danielle = {
  name : '다니엘',
  group : '뉴진스',
}

console.log(danielle);
//danielle = {};
// TypeError: Assignment to constant variable.

danielle.group = 'NewJeans'
console.log(danielle);

// ⑤ 객체의 키/밸류 값을 배열로 얻어오기
console.log('⑤ 객체의 키/밸류 값을 배열로 얻어오기--------------')
console.log(Object.keys(danielle));
console.log(Object.values(danielle));

// 좀 더 빠르게 객체 선언하기
const name = '민지';
const minJi = {
  name,
  // or
  name : name,
  // 내용이 같아서 한개만 생성 됨.
}
console.log(minJi);