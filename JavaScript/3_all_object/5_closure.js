console.log('-----------------------------------------------------');
console.log('1) Lexical Scope')

let numberThree = 3

function functionOne(){
  var numberThree = 100;
  functionTwo();
}

function functionTwo(){
  console.log(numberThree);
}

functionOne();

// 자바스크립는 선언된 위치가 상위 스코프를 정하게 된다.
// 이를 Lexical Scope 라고 한다.

console.log('-----------------------------------------------------');
console.log('2) Closure')
// 하위함수가 상위함수 보다 더 오래 살아있는 경우를 말한다.

function getNum(){
  var num = 5;

  function innerGetNum(){
    console.log('innerGetNum()');
    return num;
  }
  console.log('getNum()');
  return innerGetNum();
}

// console.log(num);  // error : ReferenceError: num is not defined

console.log(getNum());

// 위 상황에서는 innerGetNum 함수는 getNum 함수보다 오래
// 살아남지 않는다.

function GetNumber(){
  let num = 10;
  function InnerGetNumber(){
    console.log('InnerGetNumber()');
    return num;
  }
  console.log('GetNumber()');
  return InnerGetNumber;
}

const runner = GetNumber();
console.log(runner);
console.log(runner());

console.log('-----------------------------------------------------');
console.log('3) Closure 사용 예')

function cacheFunction(){
  let count = 10 * 10;
  function innerCacheFunction(inputNum){
    return count * inputNum;
  }
  return innerCacheFunction;
}

const calc = cacheFunction();
console.log(calc(3));
console.log(calc(20));