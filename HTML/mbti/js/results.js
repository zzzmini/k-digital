import { results, mbtis } from "./data.js";

// http://127.0.0.1:5000/results.html?mbti=isfj
// 위 내용 중 mbti=isfj 를 쿼리스트링이라고 함.
// 쿼리스트링을 가져오는 방법
// 콘솔로 출력 확인

const mbti = new URLSearchParams(location.search).get('mbti')
console.log(mbti)

// const result = results.mbtis['istf']
const result = results[mbtis[mbti]]
console.log(result)

const titleEl = document.querySelector('.page-title')
const characterEl = document.querySelector('.character')
const boxEls = document.querySelectorAll('.box')
const jobEls = document.querySelectorAll('.job')
const lectureEl = document.querySelector('.lecture')
const lectureImgEl = document.querySelector('.lecture img')

titleEl.innerHTML = result.title
characterEl.src = result.character

boxEls.forEach(function(boxEl, index){
  boxEl.innerHTML = result.results[index]
})

jobEls.forEach(function(jobEl, index){
  jobEl.innerHTML = result.jobs[index]
})

lectureEl.href = result.lectureUrl
lectureImgEl.src = result.lectureImg