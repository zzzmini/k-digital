const iveMembers = [
  {name : '안유진', year : 2003},
  {name : '가을', year : 2002},
  {name : '레이', year : 2004},
  {name : '장원영', year : 2004},
  {name : '리즈', year : 2004},
  {name : '이서', year : 2007},
];

const btsMembers = [
  {name : '진', year : 1992},
  {name : '슈가', year : 1993},
  {name : '제이홉', year : 1994},
  {name : 'RM', year : 1994},
];

class Country{
  name;
  idolGroups;
  constructor(name, idolGroups){
    this.name = name;
    this.idolGroups = idolGroups;
  }
}

class IdolGroup{
  name;
  members;
  constructor(name, members){
    this.name = name;
    this.members = members;
  }
}

class Idol{
  name;
  year;
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
}

class FemaleIdol extends Idol{
  sing(){
    return `${this.name}이 노래를 합니다.`;
  }
}

class MaleIdol extends Idol{
  dance(){
    return `${this.name}이 춤을 춥니다.`
  }
}

// 주어진 두개의 아이돌 배열로 만들기 - map() 이용
const cIveMembers = iveMembers.map((x)=>new FemaleIdol(x.name, x.year));
console.log('map()으로 ive 멤버(배열)를 하나씩 읽어 생성자로 그룹 만들기')
console.log(cIveMembers);

console.log('-------------------------------------');

console.log('map()으로 bts 멤버(배열)를 하나씩 읽어 생성자로 그룹 만들기')
const cBtsMembers = btsMembers.map((x)=>new MaleIdol(x.name, x.year));
console.log(cBtsMembers);

// 그룹클래스 만들기
console.log('그룹 클래스 만들기');
const iveGroup = new IdolGroup('아이브', cIveMembers);
console.log(iveGroup);

console.log('-------------------------------------');

const btsGroup = new IdolGroup('BTS', cBtsMembers);
console.log(btsGroup);

// 나라 지정해서 아이브와 BTS 넣기
console.log('Country 클래스 만들기');
const korea = new Country('대한민국', [iveGroup, btsGroup]);

console.log('출력 ---------------------------')
console.log(korea);
console.log(korea.idolGroups[0].members[0]);
console.log(cIveMembers[0].sing());

console.log(korea.idolGroups[1].members[1].dance());

// 한번에 작업하기
console.log('----------한번에 작업하기-----------')
const koreanGroup = new Country(
  '대한민국', [
    new IdolGroup(
      '아이브', 
      iveMembers.map((x)=> new FemaleIdol(x.name, x.year))
    ),
    new IdolGroup(
      'BTS',
      btsMembers.map((x)=> new MaleIdol(x.name, x.year))
    )
  ]
)

console.log(koreanGroup);
console.log(koreanGroup.idolGroups[0].members[3].sing());