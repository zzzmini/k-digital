// 1) 산술연산자
console.log(10 + 10)
console.log(10 - 10)
console.log(10 / 10)
console.log(10 * 10)
console.log(10 % 10)  // 나머지를 구하는 연산자
console.log(10 % 3)
console.log(10 * (10+10))

console.log('---------------------------')

// 2) 증감연산자
let number = 1
number++
console.log(number)

number--
console.log(number)

console.log('---------------------------')

let result = 1
console.log(result)
result = number++
// ① result = number
// ② number = number + 1
console.log(result, number) // 1 2 출력

result = number --
// ① result = number
// ② number = number - 1
console.log(result, number) // 2 1 출력

result = ++ number
// ① number = number + 1
// ② result = number
// 현대에서 거의 사용하지 않음.(뒤통수 맞을 수 있음.)
console.log(result, number)

console.log('---------------------------')
// 숫자가 아닌 타입에 +, - 사용하기
let sample = '99'
console.log(+sample)
console.log(typeof +sample)

console.log(sample)
console.log(typeof sample)

sample = true
console.log(+sample)
console.log(typeof +sample)
// 실제 true = 1로, false = 0으로 표현되기도 한다.

sample = '안유진'
console.log(+sample)
// NaN : Not a Number

console.log('---------------------------')

// 3) 할당연산자(assignment operator)
number = 100
console.log(number)
number += 10
console.log(number)
number -= 10
console.log(number)
number *= 10
console.log(number)
number /= 10
console.log(number)
number %= 10
console.log(number)

console.log('---------------------------')

// 4) 비교연산자
// ① 값의 비교
console.log(5 == 5)
console.log(5 == '5')
console.log(0 == '')
console.log(true == 1)
console.log(false == 0)
console.log(true == '1')

console.log('---------------------------')

// ② 값과 타입을 같이 한꺼번에 비교
console.log(5 === 5)
console.log(5 === '5')

console.log('---------------------------')

/**
 * ③ 관계연산자
 * - 값의 비교 : > , < , >= , <=
 * - 값과 타입을 같이 한꺼번에 비교 : !==
 */

// ④ 삼항조건연산자
console.log(10 > 0 ? '10이 0보다 크다' : '10이 0보다 작다.')

console.log('---------------------------')

// ⑤ 논리연산자(&& , ||)
console.log(true && true)
console.log(true && false)

console.log(true || true)
console.log(true || false)

console.log(10>1 && 20>2);
console.log(10>1 || 20>2);

/**
 * ⑥ 단축평가(short circuit evaluation) - 실무서 많이 씀
 *  - && 사용 : 좌측 true → 우측 반환  
 *  - && 사용 : 좌측 false → 우측 반환
 *  - || 사용 : 좌측 true → 좌측 반환   
 *  - || 사용 : 좌측 false → 우측 반환   
 */

console.log('---------------------------')
console.log(true || '아이브')
console.log(false || '아이브')

console.log(false && '아이브')
console.log(true && '아이브')

console.log(true && true && '아이브')
console.log(true && false && '아이브')

// ⑦ 지수연산자
console.log(2 ** 2)
console.log(10 ** 3)

// ⑧ null 연산자 : 좌측값이 null 혹은 undefined 이면 우측값 반환
console.log('---------------------------')
let name
console.log(name)

name = name ?? '김형민'
console.log(name)

name = name && '아이브'
console.log(name)