// 전체 13자리-- 12자리만 연산 참여
// 맨 끝자리는 비교를 위해서 사용하는 자리
let jumin = [1,4,0,4,1,6,4,1,4,0,8,1,7];
function check(jumin){
    let total = 0;
    let trueOrFalse;

    // let checkArr = [2,3,4,5,6,7,8,9,2,3,4,5];
    // for(let i=0; i<checkArr.length; i++){
    //     total = total + (jumin[i]*checkArr[i]);
    // }
    for(let i=0; i<jumin.length-1; i++){
        if(i<=7){
            total = total + (jumin[i]*(i+2))
        } else {
            total = total + (jumin[i]*(i-6))
        }
    }
    total = total % 11;
    total = 11 - total;
    total = total % 10;
    // response.rNumber = total;
    if(total == jumin[12]) {
        trueOrFalse = true;
    }
    else {
        trueOrFalse = false;
    }
    let response = {
        rNumber : total,
        rResult : trueOrFalse,
    };
    return response;
}

let result = check(jumin);
console.log(result);
if(result.rResult){
    console.log("옳바른 주민번호입니다.");
} else {
    let report = `틀린번호입니다. 구청에가서 ${result.rNumber}
로 바꿔달라 하세요`;
    console.log(report);
}
