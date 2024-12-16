// ① for loop
// 0에서 9까지 출력+
for(let i=0 ; i < 10 ; i ++){
  console.log(i);
}

// ② 중첩 for Loop
for (let i=0; i < 3; i++){
  for(let j=3; j > 0; j--){
    console.log(i, j);
  }
}

console.log('')

// ③ 퀴즈> * 을 이용해서 5×5의 정사각형, 우측으로
// 기울어진 삼각형을 
// 각각 출력하시오.

console.log('--- 5×5의 정사각형 ---');
let square = '';
let side = 5;
for(let i=0; i<side; i++){
  for(let j=0; j<side; j++){
    square = square + '*';
  }
  square = square + '\n';
}
console.log(square);

console.log('--- 우측 기울어진 삼각형 ---');
for(let i=0; i<side; i++){
  for(let j=0; j<i; j++){
    square = square + '*';
  }
  square = square + '\n';
}
console.log(square);

console.log('------------------')

// ④ for ~ in Loop
const yuJin = {
  name : '안유진',
  year : 2003,
  group : 'ive'
}

for(let key in yuJin){
  console.log(key);
}

console.log('------------------')
const iveMemberArray = ['안유진', '가을', '레이', '장원영', '리즈', '이서'];
for(let key in iveMemberArray){
  //console.log(key);
  console.log(`${key} : ${iveMemberArray[key]}`);
}

console.log('------------------')
// ⑤ for ~ of loof : iterator 한 자료구조에서 사용가능(list, array)
for(let value of iveMemberArray){
  console.log(value);
}

console.log('------------------')
// ⑥ while 구문
let number = 0;
while(number < 10){
  number++;
  console.log(number);
}
console.log(number);

console.log('------------------')
// ⑦ do ~ while 구문
number = 0;
do {
  number++;
  console.log(number);
} while(number < 10);
console.log(number);

// ⑧ break/continue 구문
console.log('break------------------')
for(let i=0; i<10; i++){
  if(i===5){
    break;
  }
  console.log(i);
}

console.log('continue------------------')
for(let i=0; i<10; i++){
  if(i===5){
    continue;
  }
  console.log(i);
}