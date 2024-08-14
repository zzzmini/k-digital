const codeTest="코드테스트"
console.log(codeTest)

// 문자열 안에 작은따옴표, 큰따옴표 처리
let ive = "'아이브' 장원영"
console.log(ive)

// Escape Character
let iveYuJin = "아이브 \n 안유진"
iveYuJin = "아이브 \t 안유진"
console.log(iveYuJin)

const iveGaeul = '아이브 \'가을'
console.log(iveGaeul)

// Template Literal --- 백틱(``)
const groupName = "아이브"

// 아이브 안유진
console.log(groupName + " 안유진")

// 백틱으로 처리하기
console.log(`${groupName} 장원영`)

// 문제. 
// 안녕하세요. 저는 부트캠프 000 입니다.
// 변수 선언 : 부트갬프, 여러분 이름 저장 할 변수
let bootCamp = "부트캠프"
let myName = "김형민"
console.log(`안녕하세요. 저는 ${bootCamp} ${myName}입니다.`)

// null 값 확인
let init = null
console.log(init)
console.log(typeof init)