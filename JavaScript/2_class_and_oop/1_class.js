// ① 아이돌멤버 클래스 정의
class IdolMember{
  name;
  year;

  // 생성자
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
}

const yuJin = new IdolMember('안유진', 2003);
console.log(yuJin);
const gaeul = new IdolMember('가을', 2002);
console.log(gaeul);
const ray = new IdolMember('레이', 2004);
console.log(ray);
const jangWonYoung = new IdolMember('장원영', 2004);
console.log(jangWonYoung);
const liz = new IdolMember('리즈', 2004);
console.log(liz);
const leeseo = new IdolMember('리즈', 2007);
console.log(leeseo);

// ② 인스턴스에서 값 가져오기
console.log('② 인스턴스에서 값 가져오기 ---------')
console.log(leeseo.name);
console.log(leeseo.year);

// ③ method 정의
console.log('③ method 정의 ---------')
class IdolMember2{
  name;
  year;

  // 생성자
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
  sayName(){
    return `안녕하세요. 저는 ${this.name} 입니다.`;
  }
}

const minJi = new IdolMember2('민지', 2004);
console.log(minJi.sayName());
console.log(typeof IdolMember2);
console.log(typeof minJi);