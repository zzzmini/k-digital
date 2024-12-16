console.log(name)  // undefined 오류가 발생하지 않음!!
var name = '김형민'
console.log(name)

// let과 const도 hoisting 처리 된다.

console.log(yuJin)
//ReferenceError: Cannot access 'yuJin' before initialization
let yuJin = '안유진'