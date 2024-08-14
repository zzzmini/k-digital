/** if 구문
 * if( 조건 ) {
 *  참일 때 실행할 문장;
 * } else {
 *  거짓일 때 실행할 문장
 * }
 * */ 
// 문제1. number = 5, 출력 : 5는 홀수 입니다.
let number = 6;
if((number % 2) == 0){
    console.log(`${number} 는 짝수입니다.`)
} else {
    console.log(`${number} 는 홀수입니다.`)
}
 
/**
 * 다중 if
 * if(조건1) {
 *  참
 * } else if(조건2) {
 *  참
 * } ....., else {
 * }
 * 
 * score = 83,  수, 우, 미, 양 , 가 중 결과 출력
 */ 
let score = 65;
let result = '';
if(score >= 90) {
    result = '수';
} else if(score >= 80) {
    result = '우';
} else if(score >= 70) {
    result = '미';
} else if(score >= 60) {
    result = '양'
} else {
    result = '가';
}
console.log(`점수는 ${result}입니다.`)
/**
 * swich case 구문
 * swich(검사할값){
 *  case 조건 :
 *      실행문장;
 *      break;
 *  case 조건 :
 *      실행문장;
 *      break;
 *  defalt :
 *      실행문장;
 *      break;
 * }
 */
const englishDay = 'SUN';
let koreanDay = '';
switch(englishDay){
    case 'MON':
        koreanDay = "월요일";
        break;
    case 'TUE' :
        koreanDay = "화요일";
        break;
    case 'WEN' :
        koreanDay = "수요일";
        break;
    case 'THU' :
        koreanDay = "목요일";
        break;
    case 'FRI' :
        koreanDay = "금요일";
        break;    
    default :
        koreanDay = "주말";
        break;    
}
console.log(koreanDay);