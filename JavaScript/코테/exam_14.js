// 문제 14. 문자열 반복
// 문자열 S를 입력받은 후에, 
// 각 문자를 R번 반복해 새 문자열 P를 만든 후 
// 출력하는 프로그램을 작성하시오. 

let fs = require('fs');
let input = fs.readFileSync('input_14.txt')
            .toString().split('\n');
let count = Number(input[0]);
let result = '';
for(let i=1; i<=count; i++){
    let [repeat, str] = input[i].split(' ');
    let result = '';
    for(let j=0; j < str.length; j++){
        result = result + str.charAt(j).repeat(repeat)
        // console.log(str.charAt(j).repeat(repeat));
    }
    console.log(result);
}