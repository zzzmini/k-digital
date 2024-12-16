console.log('-----------------------------------------------------');
console.log('1) 일반적 메서드 생성 및 활용')

function IdolModel2(name, year){
  this.name = name;
  this.year = year;
  this.sayHello = function(){
    return `${this.name}이 인사를 합니다.`
  }
}

const yuJin = new IdolModel2('안유진', 2003);
console.log(yuJin.sayHello());

const wonYoung = new IdolModel2('장원영', 2004);
console.log(wonYoung.sayHello());

console.log(yuJin.sayHello === wonYoung.sayHello);

// 특정 메서드가 어느 인스턴스 클래스에서 나왔는지 확인하는 법
console.log(yuJin.hasOwnProperty('sayHello'));  //true

//  기능이 동일하나 클래스마다 고유한 영역에 생성되므로 메모리가 낭비됨.

console.log('-----------------------------------------------------');
console.log('2) 공유 프로퍼티 만들기')

function IdolModel3(name, year){
  this.name = name;
  this.year = year;
};

IdolModel3.prototype.sayHi = function(){
  return `${this.name}이 인사를 합니다.`;
};

const yuJin3 = new IdolModel3('안유진', 2003);
console.log(yuJin3.sayHi());

const wonYoung3 = new IdolModel3('장원영', 2004);
console.log(wonYoung3.sayHi());

console.log(yuJin3.sayHi === wonYoung3.sayHi);  //true

// 특정 메서드가 어느 인스턴스 클래스에서 나왔는지 확인하는 법
console.log(yuJin3.hasOwnProperty('sayHi'));  //true

console.log('-----------------------------------------------------');
console.log('3) 공유 프로퍼티 Override')

function IdolModel4(name, year){
  this.name = name;
  this.year = year;

  this.sayHi = function(){
    return `안녕하세요 인스턴스 메서드입니다.`;
  };
};

IdolModel4.prototype.sayHi = function(){
  return `안녕하세요 프로토타입 메서드입니다.`;
};

const yuJin4 = new IdolModel4('안유진', 2003);
console.log(yuJin4.sayHi());