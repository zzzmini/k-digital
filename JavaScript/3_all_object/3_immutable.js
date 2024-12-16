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
yuJin.setAge = yuJin.getAge;
console.log(yuJin);
console.log('-----------------------------------------------------');
console.log('1) Extensible : 객체 확장 가능 여부 확인')
console.log('▷ 확장가능? ' + Object.isExtensible(yuJin));
console.log('▷ 확장 못하게 하기');
Object.preventExtensions(yuJin);
console.log('▷ 확장테스트 --------------------------------------');
yuJin.height = 172;
console.log(yuJin);
console.log('▷ 확장가능? ' + Object.isExtensible(yuJin));

console.log('-----------------------------------------------------');
console.log('2) Seal : 봉인하기  ---- 가장 많이 사용 함.(default : false')
console.log('▷ 봉인되었음?(추가/삭제 불가) ' + Object.isSealed(yuJin));
console.log('▷ 봉인하기');
Object.seal(yuJin);
console.log('▷ 봉인테스트 --------------------------------------');
yuJin.height = 172;
delete yuJin.name;
console.log(yuJin);
console.log('▷ 봉인되었음? ' + Object.isSealed(yuJin));

console.log('-----------------------------------------------------');
console.log('3) Freeze : 얼려버기기(읽기전용) - 많이 사용 함.(default : false')
console.log('▷ 읽기 전용(Freeze)? ' + Object.isFrozen(yuJin));
console.log('▷ 얼려버리기');
Object.freeze(yuJin);
console.log('▷ 다 얼었나? --------------------------------------');
yuJin.height = 172;
yuJin.name = 'An Yu Jin';
console.log(yuJin);
console.log('▷ Frozon? ' + Object.isFrozen(yuJin));