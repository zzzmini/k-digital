const codeTest = '코드테스트'
console.log(codeTest)

// 문자열 안에 작은 따옴표와 큰 따옴표 처리하기
const ive = "'아이브' 장원영"
console.log(ive)

// Escape Character
const iveYuJin = '아이브 \n안유진'
console.log(iveYuJin)

const iveWonYoung = '아이브 \t장원영'
console.log(iveWonYoung)

const iveGaEul = '아이브 \' 가을'
console.log(iveGaEul)

console.log('-------------------')

// Template Literal에서 백틱(`)으로 변수 사용
const groupName = '아이브'
console.log(groupName + '안유진')
console.log(`${groupName} 안유진`)