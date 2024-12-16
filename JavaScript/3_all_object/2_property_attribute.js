const wonyoung = {
  name : '장원영',
  year : 2004,
};

// 모든 property attribute 출력
console.log('1) 모든 property attribute 출력--------------------------');
console.log(Object.getOwnPropertyDescriptor(wonyoung, 'name'));
console.log('-------------------------------------------------------');

// data property and access property
console.log('2) Data Property and Access Property-------------------');
const yuJin = {
  name : '안유진',
  year : 2003,
  age : 0,
  get getAge(){
    return new Date().getFullYear() - this.year;
  },
  set setAge(age){
    this.age = age;
  }
}
console.log('yuJin.age = ' + yuJin.age);
console.log(Object.getOwnPropertyDescriptor(yuJin, 'age'));

console.log('▷ 나이 계산해서 얻어오기 → yuJin.setAge = yuJin.getAge;')
yuJin.setAge = yuJin.getAge;
console.log(Object.getOwnPropertyDescriptor(yuJin, 'age'));
console.log('-----------------------------------------------------');

// data property의 재정의
console.log('3) Data Property 재정의 → ① 간단한 추가 방법--------------');
yuJin.height = 172;
console.log(yuJin);


console.log('3) Data Property 재정의 → ② 직접 추가 방법--------------');
console.log(wonyoung);
Object.defineProperty(wonyoung, 'weight', {
  value : 45, writable : true, enumerable : true, configurable : false
});
console.log(wonyoung);

console.log('3) Data Property 재정의 → ③ writable → false ----------');
Object.defineProperty(yuJin, 'height', {writable : false});
yuJin.height = 180;
// 값이 변경되지 않지만 오류도 발생하지 않는다.
console.log(yuJin);

console.log('4) Data Property 재정의 → ④ enumerable → false ---------');
console.log(Object.keys(wonyoung));
for(let key in wonyoung){
  console.log(key);
};
console.log('enumerable → false로 변경 후---------------------------');
Object.defineProperty(wonyoung, 'name', {enumerable : false});
for(let key in wonyoung){
  console.log(key);
};