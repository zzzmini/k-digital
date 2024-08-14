// 두 수를 받아서 곱한 후 결과 리턴
function muliple(a, b){
    return a * b;
}
let result = muliple(10, 20);
console.log(result);

// 1. 명시적함수 선언방법
const multi_01 = function(x, y){
    return x * y;
}
console.log(multi_01(3, 4));
// 2. 화살표 함수(Arrow Function)
const multi_02 = (x, y)=>{
    return x * y;
}
console.log(multi_02(7,8));
// 3. 더 간단하게 표현하는 법(단 리턴 줄이 한줄 일 때)
const mulit_03 = (x, y) => x*y;
// 4. 즉시 실행 함수
(function (x, y) {
    console.log(x*y);
})(4,5);

// 5. 즉시 실행 함수 => 화살표 함수
((x, y) => {
    console.log(x*y);
})(4,5);
