// 1) 명시적 형변환
let age = 32;
let stringAge = age.toString();
console.log(typeof stringAge, stringAge);

// 2) 암묵적 형변환
let test = age + '';
console.log(typeof test, test);

// 기능적으로는 가능하나 명시적 코드작성을 위해 거의 사용되지 않음  

console.log(typeof (99).toString(), (99).toString());
console.log(typeof parseInt('0'), parseInt('0'));
console.log(typeof parseFloat('0.99'), parseFloat('0.99'));

// boolean 타입으로 변환
console.log('--boolean 타입으로 변환--');
console.log(' !\'x\' : ' + ! 'x');
console.log(' !!\'x\' : ' + !! 'x');
console.log(' !!\'\' : ' + !! '');
console.log(' !! 0 : ' + !! 0);
console.log(' !! \'0\' : ' + !! '0');
console.log(' !! \'false\' : ' + !! 'false');
console.log(' !! false : ' + !! false);
console.log(' !! undefind : ' + !! undefined);
console.log(' !! null : ' + !! null);
console.log(' !! {} : ' + !! {});
console.log(' !! [] : ' + !! []);
