class IdolMember{
  name;
  year;

  // 생성자
  constructor(name, year){
    this.name = name;
    this.year = year;
  }

  /**
   * ① getter and setter 생성   
   * 1) 데이터를 가공해서 새로운 데이터를 반환할 때
   * 2) private 한 값을 반환할 때
   * */ 

  get getNameAndYear(){
    return `${this.name} - ${this.year}`;
  }

  set setName(name){
    this.name = name;
  }

  playDance(){
    return `${this.name}이 춤춰요`;
  }
}

const wonYoung = new IdolMember('장원영', 2003);
// getter 호출 시 함수에 붙이는 괄호()를 붙이지 않는다.
console.log(wonYoung.getNameAndYear);

// setter 는 변수에 값을 직접 할당하는 것과 같은 방법을 사용한다.
//wonYoung.setName('이무기');  ----- 오류 발생함.
wonYoung.setName = 'JangWonYoung';

console.log(wonYoung);
console.log(wonYoung.playDance());

  /**
   * ② private member 변수의 사용  
   * 변수를 # 으로 선언하고 getter를 통해 접근한다.
   * */ 
  
console.log('② private member 변수의 사용 --------')  
class IdolMember2{
  #name;
  year;

  // 생성자
  constructor(name, year){
    this.#name = name;
    this.year = year;
  }
  // getter
  get getName(){
    return this.#name;
  }

  //setter
  set setName(name){
    this.#name = name;
  }
}

const yuJin = new IdolMember2('안유진', 2003);
// private로 선언하면 console.log(yuJin); 결과에서도 확인이 불가하다.
console.log(yuJin);
console.log(yuJin.name);  // getter가 없으면 undefined
console.log(yuJin.getName);

yuJin.setName = 'AnYuJin';
console.log(yuJin);
console.log(yuJin.getName);
console.log(yuJin.year);