// data.js에서 가져오기
import { questions } from './data.js';

const progressValueEl = document.querySelector('.progress .value')
const numberEl = document.querySelector('.number')
const questionEl = document.querySelector('.question')
const choice1El = document.querySelector('.choice1')
const choice2El = document.querySelector('.choice2')

let currentNumber = 0
let mbti = ''

function renderQuestion(){
  const question = questions[currentNumber]
  numberEl.innerHTML = question.number
  questionEl.innerHTML = question.question
  choice1El.innerHTML = question.choices[0].text
  choice2El.innerHTML = question.choices[1].text
  progressValueEl.style.width = (currentNumber + 1)*10 + '%' 
}

// 처음 시작화면에서는 첫 질문을 가져와서 뿌려준다.
renderQuestion()

// 질문에 대한 첫번째, 두번째 답을 클릭했을 경우
//  choices: [
//   { text: '파티 스텝은 못하지ㅎ...<br>(그래도 파티는 재밌겠다 히히)', value: 'i' },
//   { text: '재밌겠다!<br>○○한테 같이 지원하자고 해야지~', value: 'e' }
// ]
// choices[0] : 첫번째 text 선택 → 첫번째 value 값 가져오기
// choices[1] : 두번째 text 선택 → 두번째 value 값 가져오기
choice1El.addEventListener('click', function(){nextQuestion(0)})
choice2El.addEventListener('click', function(){nextQuestion(1)})

// 1. 선택한 답변을 mbti 변수에 저장
// 2. 다음 질문번호를 생성해서 질문을 뿌려주는 renderQuestion() 함수 호출
function nextQuestion(choiceNumber){
  console.log('nextQuestion Function')
  const question = questions[currentNumber]
  // 만약 맨 마지막 질문이면 결과 보여주기 페이지로 이동
  if(currentNumber === questions.length - 1){
    showResultPage()
    return
  }
  mbti = mbti + question.choices[choiceNumber].value
  currentNumber = currentNumber + 1;
  renderQuestion()
}

function showResultPage(){
  // 쿼리 스트링을 만들어 결과페이지 호출
  location.href = './results.html?mbti=' + mbti
}