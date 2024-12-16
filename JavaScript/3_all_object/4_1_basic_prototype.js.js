console.log('-----------------------------------------------------');
console.log('1) 빈 클래스 생성하고 살펴보기')

const testObj = {};
console.log(testObj.__proto__);
// [Object: null prototype] {}


// __proto__ : 모든 객체에 존재하는 프로퍼티이다.
// 클래스의 상속에서 부모클래스에 해당되는 값이다.

function IdolModel(name, year){
  this.name = name;
  this.year = year;
}

console.log(IdolModel.prototype);   // 결과 :  {}

console.log('-----------------------------------------------------');
console.log('2) 내부의 모든 숨겨진 prototype 살펴보기')
console.dir(IdolModel.prototype, {showHidden:true,});
/* <ref *1> {
  [constructor]: [Function: IdolModel]
   {
    [length]: 2,
    [name]: 'IdolModel',
    [arguments]: null,
    [caller]: null,
    [prototype]: [Circular *1]
  }
} */

console.log('-----------------------------------------------------');
console.log('3) prototype과 IdolModel → circular reference')
console.log(IdolModel.prototype.constructor === IdolModel);
console.log(IdolModel.prototype.constructor.prototype === IdolModel.prototype);

console.log('-----------------------------------------------------');
console.log('4) 부모객체 여부확인해 보기')
const yuJin = new IdolModel('안유진', 2003);
console.log(yuJin.__proto__);
let result = yuJin.__proto__ === IdolModel.prototype
console.log('yuJin.__proto__ === IdolModel.prototype : ' + result);

result = IdolModel.__proto__ === Function.prototype
console.log('IdolModel.__proto__ === Function.prototype : ' + result);

result = Function.prototype.__proto__ === Object.prototype
console.log('Function.prototype.__proto__ === Object.prototype : ' + result);
console.log('-----------------------------------------------------');

console.log(yuJin.toString());
result = yuJin.toString() === Object.prototype.toString()
console.log('yuJin.toString() === Object.prototype.toString() : ' + result);

console.log('-----------------------------------------------------');
