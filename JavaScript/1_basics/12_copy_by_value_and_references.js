// ② call by value
console.log('② call by value -------')
let original = '안녕하세요';
let clone = original;
console.log('original : ' + original);
console.log('clone : ' + clone);

clone = clone + '뉴진스입니다.';
console.log('original : ' + original);
console.log('clone : ' + clone);

console.log(original === clone);

// ③ call by references
console.log('② call by references -------')
let originalObject = {
  name : '장원영',
  group : '아이브',
}

let cloneObject = originalObject;
console.log(originalObject);
console.log(cloneObject);
console.log('----------------------------')
cloneObject.name = '민지';
cloneObject.group = '뉴진스';
console.log(originalObject);
console.log(cloneObject);

console.log(originalObject === cloneObject);

// ④ object 에서 spread operator 사용하기
console.log('④ object 에서 spread operator 사용하기-------')
let wonYoung1 = {
  name : '장원영',
  group : '아이브',
}

const wonYoung2 = wonYoung1;

let wonYoung3 = {
  name : '장원영',
  group : '아이브',
}

console.log(wonYoung1 === wonYoung2);
console.log(wonYoung1 === wonYoung3);
console.log(wonYoung2 === wonYoung3);
console.log('spread operator로 복사하기 -----')
const wonYoung4 = {... wonYoung3};
console.log(wonYoung4 === wonYoung3);