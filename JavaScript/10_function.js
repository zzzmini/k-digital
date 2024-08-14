// 1) 함수의 생성
function oneValuePrint(don) {
    console.log(don);
}

oneValuePrint();
console.log('작업 끝');

// 2) 두개의 수를 전달해서 곱한 결과를 받는함수
function multiply(x, y) {
    return x * y;
}
let result = multiply(10,20);
console.log("출력 : " + result);

// 3) default 파라미터 사용
// x와 y를 비교해서 큰값에서 작은값을 빼서 리턴
function minus(x, y){
    if(x < y){
        return y - x;
    } else {
        return x - y;
    }
}
console.log(minus(2, 5));
console.log(minus(4, 2));