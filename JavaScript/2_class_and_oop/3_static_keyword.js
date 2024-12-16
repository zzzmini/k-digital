// ① static 변수의 선언과 사용
class IdolMember{
  static groupName = '뉴진스';
  name;
  year;

  // factory constructor : 자주 사용함.
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
  static getGroupName(){
    return this.groupName;
  }
}

const minJi = new IdolMember('민지', 2004);
// static 으로 선언한 groupName은 보이지 않는다.
console.log(minJi);
console.log('minJi.groupName = ' + minJi.groupName); // undefined
console.log('IdolMember.groupName = ' + IdolMember.groupName);
console.log(IdolMember.getGroupName());


// ② factory constructor
console.log('② factory constructor-----')
// Object type 으로부터 값을 입력받아 클래스 인스턴스 생성
class IdolMember2{
  name;
  year;

  // factory constructor : constructor
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
  // factory constructor : object
  static fromObject(Object){
    return new IdolMember2(Object.name, Object.year);
  }

  // factory constructor : list
  static fromList(list){
    return new IdolMember2(
      list[0],
      list[1],
    )
  }
}

const gaEul = IdolMember2.fromObject(
  {
    name : '가을',
    year : 2002
  }
);

console.log(gaEul);

const yuJin2 = IdolMember2.fromList(['안유진', 2002]);
console.log(yuJin2);

// factory constructor를 사용하면 다양한 형태의 data를 입력받아 
// 객체 인스턴스를 생성하여 활용할 수 있다.