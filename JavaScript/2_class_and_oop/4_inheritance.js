class IdolModel{
  name;
  year;
  constructor(name, year){
    this.name = name;
    this.year = year;
  }
}

class FemaleIdolModel extends IdolModel{
  dance(){
    return `${this.name}이 춤을 춥니다.`;
  }
}

class MaleIdolModel extends IdolModel{
  sing(){
    return `${this.name}이 노래를 합니다.`;
  }
}

const yuJin = new FemaleIdolModel('안유진', 2003);
console.log(yuJin);
console.log(yuJin.dance());
console.log(yuJin.name);

const jiMin = new MaleIdolModel('지민', 1995);
console.log(jiMin);
console.log(jiMin.sing());
console.log(jiMin.year);

const jyp = new IdolModel('박진영', 1971);
console.log(jyp);
console.log(jyp.name);
//console.log(jyp.dance());

console.log('instance 확인 -------------------')
let result = yuJin instanceof IdolModel;
console.log('yuJin instanceof IdolModel = ' + result);
result = yuJin instanceof FemaleIdolModel;
console.log('yuJin instanceof FemaleIdolModel = ' + result);
result = yuJin instanceof MaleIdolModel
console.log('yuJin instanceof MaleIdolModel = ' + result);