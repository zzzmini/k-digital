/**
 * for 구문 -- 시간복잡도 : O(n)
 * for(첨자=초기화 ; 조건 ; 증분){
 * 
 * }
 * 1부터 10까지 더해서 출력
 */
let sum = 0;
for(let i =1; i<=10; i = i + 2){
    sum = sum + i;
    // sum += i;
}
console.log('sum = ' + sum);
sum = 0;
// 배열을 순회하면서 값을 읽어서 더하기
let value = [4, 9, 2, 7, 5, 11];
console.log(value.length);
for(let i = 0; i < value.length; i++){
    sum = sum + value[i];
}

console.log('ArrSum = ' + sum);

/**
 * 중첩 for 구문
 * for(let i=1 ; i<=9; i++){
 *  for(let j=1; j<=9; j++){
 *      실행문장
 *  }
 * }
 * 구구단을 출력
 * =====  2단 =====
 * 2 * 1 = 2
 * 2 * 2 = 4
 * .....
 * =====  3단 =====
 * 3 * 1 = 3
 * 3 * 2 = 6
 * .....
 * 
 */

for(let i = 2; i <= 9; i++){
    console.log(`==== ${i}단 ====`);
    for(let j = 1; j <= 9; j++){
        console.log(`${i} * ${j} = ${i * j}`);
    }
}

/**
 * #
 * ##
 * ###
 * ####
 * #####
 */

let star='';
for(i=1; i<=5; i++){
    star = star + "*";
    console.log(star);
}
star='';
for(i=1; i<=5; i++){
    for(let j=1; j<=i; j++){
        star = star + "*";
    }
    star = star + "\n";
}
console.log(star);
console.log("거꾸로 찍기------------------")
star = '';
let line = 5;
for(let i = line; i>0; i--){
    for(let j = 1; j <= i; j++){
        star = star + "*";
    }
    star = star + "\n";
}
console.log(star)

console.log("거꾸로 찍기(두번째------------------")
star = '';
for(let i = 1; i<=line; i++){
    for(let j = 1; j <= line + 1 - i; j++){
        star = star + "*";
    }
    star = star + "\n";
}
console.log(star)

// for ~ in 구문(배열, Object, 리스트 내용을 순회)
const yujin = {
    name : '안유진',
    year : 2003,
    group : 'ive'
}

for(let x in yujin){
    console.log(x);
    console.log(yujin[x]);
}

console.log('---------------')
// for ~ of 구문
const iveMember = ['안유진','장원영','가을', '이서'];
for(let member of iveMember){
    console.log(`${member}`);
}

const iveMembers = [ 
    {name : '장원영',
     year : 2002,
     age : 22}, 
    {name : '안유진',
     year : 2001,
     age : 23}
  ]
for(let m of iveMembers){
    console.log(m.name + " " + m.age);
}