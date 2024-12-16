class IdolModel{
  name;
  year;
  constructor(name, year){
    this.name = name;
    this.year = year;
    }
  sayHello(){
    return `안녕하세요 ${this.name}입니다.`;
  }
}

class FemaleIdolModel extends IdolModel{
  // 자식클래스에만 존재하는 파트(노래? 춤?)
  part;

  // construct를 재정의 한다.
  constructor(name, year, part){
    super(name, year);  // super()는 부모의 생성자를 호출
    this.part = part;
  }

  // 부모클래스의 sayHello() 메서드를 재정의
  sayHello(){
    return `안녕하세요. ${this.name}입니다. 저는 ${this.part}를 맡고 있습니다.`
    // javascrip는 전통적인 OOP가 아니기 때문에 this.name이라고 표현해야 함.
  }

  dance(){
    return `${this.name}이 춤을 춥니다.`;
  }
}

// 테스트
const yuJin = new FemaleIdolModel('안유진', 2003, '보컬');
console.log(yuJin);
console.log(yuJin.sayHello());