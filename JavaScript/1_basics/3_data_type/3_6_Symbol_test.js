const test1 = '1'
const test2 = '1'
console.log(1 == '1')
console.log(test1 == test2)
console.log(test1 === test2)

console.log('-------------------------')

const symbol1 = Symbol('1')
const symbol2 = Symbol('1')
console.log(symbol1 === symbol2)
console.log(symbol1 === test1)