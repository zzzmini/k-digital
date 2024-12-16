// ① error 객체의 생성
console.log('① error 객체의 생성 -----');
function runner1(){
  console.log('Hello');
  throw new Error('큰 문제가 생겼습니다.');
  console.log('Reach here?')
}

runner1();

// ② try ~ catch 구문으로 수정하기
console.log('② try ~ catch 구문으로 수정하기 -----');
function runner2(){
  try{
    console.log('Hello');
    throw new Error('큰 문제가 생겼습니다.');
    console.log('Reach here?')
  } catch(e) {
    console.log('---------catch---------');
    console.log('무슨 문제가 있나요?');
    console.log(e);
  } finally {
    // finally의 사용은 선택적이나 사용했을 때는 무조건 해당 block이 실행 됨
    console.log('---------finally---------');
  }
}

runner2();