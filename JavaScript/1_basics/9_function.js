// 1) 단일 함수의 생성
console.log('1) 단일함수의 생성----------------')
function calculate(number){
  console.log((number*10/2%3).toString());
}

calculate(4);

// 2) 여러개 파라미터 사용
console.log('2) 여러개 파라미터 사용-----------')
function multiply(x, y){
  console.log(x * y);
}
multiply(2, 4);

// 3) default 파라미터 사용
console.log('3) default 파라미터 사용-----------')
function minus(x, y = 1){
  console.log(x - y);
}
minus(5);
minus(5, 2);

// 4) 결과 반환받기
console.log('4) 결과 반환받기 -----------------')
function divide(x, y){
  return x / y;
}
console.log(divide(7, 3));

// 5) Arrow 함수
console.log('5) Arrow 함수 -----------------')
// ① 명시적 함수 선언 방법
const multi01 = function(x,y){
  return x * y;
}
// arrow 함수 표현법
const multi02 = (x, y) => {
  return x * y;
}
console.log('multi01(7, 3) : ' + multi01(7, 3));
console.log('multi02(7, 3) : ' + multi02(7, 3));

// 간편하게 표현하는 법
const multiply3 = (x, y) => x*y;
console.log(multiply3(2, 3));

// 인자가 1개 일때
const multiply4 = x => x*2;
console.log(multiply4(2));

// 6) agruments 키워드
console.log('6) agruments 키워드--------------')
const multiplyThree = function(x, y, z){
  console.log(arguments);
  return x*y*z;
}
// arguments 키워드는 Arrow Function에서는 사용 불가

console.log(multiplyThree(4,5,6));

console.log('무한 agruments 받기--------------')
const multiplyAll = function(...agruments){
  return Object.values(arguments).reduce((a,b) => a*b, 1);
}
console.log(multiplyAll(2,3,4,5,6,7,8,9));


// Immediately invoked function
console.log('즉시 실행함수--------------------');
(function (x, y){
  console.log(x*y);
})(4, 5);

// 타입확인
console.log('타입확인------------------------');
console.log(typeof multiply);
console.log(multiply instanceof Object);