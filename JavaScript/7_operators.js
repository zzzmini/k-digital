// 1) 산술연산자
console.log(10+10)
console.log(10-10)
console.log(10*10)
console.log(10/3)
// 나머지 연산자
console.log(10 % 3)
console.log(3 % 7)

console.log("------------------------")

// 2) 증감연산자
let number = 1;
number = number + 1;
console.log(`number =  ${number}`);
number ++;
console.log(`number =  ${number}`);
number--;
console.log(`number =  ${number}`);

number = 1;
let result = 1;
result = number++;
console.log(result , number);
result = ++number;
console.log(result , number);

console.log("------------------------")
// 숫자가 아닌곳에 "+, -" 사용하기
let sample = '99';
console.log(+sample);
console.log(typeof sample);
console.log(typeof +sample);

sample = true;
console.log(typeof sample)
console.log(typeof +sample, +sample)

sample = '안유진';
console.log(+sample);
// NaN(Not A Number)

// 3) 할당연산자
number = 100;
number = number + 10;
number += 10;
console.log("---------------")
// 4) 비교연산사
console.log(5 == 5);
console.log(5 == '5');
console.log(5 === '5');
console.log(0 == '');
console.log(1 == true);
console.log(false == 0);
console.log(true == '김형민');

// 5) 관계연산자
// >, < , >=, <=, !==

// 6) 삼항연산자
console.log(10 > 0? '참': '거짓');
let a =10
if( a > 11){
    console.log("참");
} else {
    console.log("거짓");
}

// 7) 논리 연산자(And - && , Or - ||, Not - !)
let x = 3;
console.log(x>=2 && x<=5);

// 8) 단축평가
console.log('----------------')
console.log(true || "김형민");
console.log(false || "김형민");

console.log(true && "김형민");
console.log(false && "김형민");

console.log(true && true && "김형민");
console.log(true && false && "김형민");

console.log(true || true  || "김형민");
console.log(false || false || "김형민");
// 9) 지수 연산자 : **
// 10) null 연산
console.log('==================')
let myName;
console.log(myName);
myName = myName ?? '김형민';
console.log(myName);
myName = myName && '아이브';
console.log(myName);