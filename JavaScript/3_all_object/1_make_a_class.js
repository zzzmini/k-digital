// 1) object를 생성해서 객체 생성 → { key : value }
console.log('1) object를 생성해서 객체 생성 → { key : value }');
const yuJin = {
  name : '안유진',
  year : 2003,
};
console.log(yuJin);
console.log('----------------------------------');

// 2) class를 instance화 해서 생성 → OOP
console.log('2) class를 instance화 해서 생성 → OOP');
class Idol{
  name;
  year;
  constructor(name, year){
    this.name = name;
    this.year = year
  }
}
const wonyoung = new Idol('장원영', 2004);
console.log(wonyoung);
console.log('----------------------------------');

// 3) function을 사용해서 객체 생성하는 방법
console.log('3) function을 사용해서 객체 생성하는 방법')
console.log('① this 키워드 사용하기')
// 함수는 생성자가 존재하지 않는다.
// this 키워드를 사용할 때만 new 사용가능

function IdolFunction(name, year){
  this.name = name;
  this.year = year;
}

const minJi = new IdolFunction('민지', 2004);
console.log(minJi);
console.log('----------------------------------------');
console.log('② new로 인스턴스가 만들어 지도록 조치하기')

function girlGroup(name, memberName){
  if(! new.target){
    return new girlGroup(name, memberName);
  }
  this.name = name;
  this.memberName = memberName;
};

console.log(girlGroup('NewJeans', '다니엘'));
console.log('----------------------------------------');

console.log('③ Arrow 함수로 생성하기')
const girlGroupNewJeans = (name, year) => {
  this.name = name;
  this.year = year;
};

/**
 * ※ 화살표 함수를 사용하면 안되는 곳
 * 1) 화살표 함수로 메소드를 정의하는 것은 피해야 한다. 
 * 2) 화살표 함수는 생성자 함수로 사용할 수 없다. 
 * 3) addEventListener 함수의 콜백 함수를 화살표 함수로 정의하면 
 *    this가 상위 컨택스트인 전역 객체 window를 가리킨다.
 * 4) 클래스의 정의도 피한다.
 */