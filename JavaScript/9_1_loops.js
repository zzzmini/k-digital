// while 구문
// 1 ~ 10 까지 더하기
let i = 0;
let sum = 0;
while (i < 10) {
    i ++;
    sum = sum + i;

    console.log(sum)
}

// do ~ while 구문
let k = 0;
let sumValue = 0;
do {
    k = k + 1;  // k++
    sumValue = sumValue + k;
} while (k < 10);
console.log(sumValue);

// break, continue 구문
// 10번 회전을 하는데 1~5까지만 더한 후 빠져나오기

for(let i=1; i<=10; i++){
    if(i == 6) break;
    console.log(i);
}
console.log('====================')
// 1~10까지 출력하는데, 5를 제외하고 출력
for(let i=1; i<=10; i++){
    if(i==5) continue
    console.log(i);
}

// 형변환(명시적형변환, 암묵적형변환)
let age = 32;
let stringAge = age.toString();
let a = [1,2,3];
console.log(a.length);






