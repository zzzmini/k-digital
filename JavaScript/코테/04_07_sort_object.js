let data = [
    {name: '홍길동', score : 90},
    {name: '김철수', score : 85},
    {name: '박영희', score : 99},
];
console.log(data);
// 성적 오름차순 정렬하기
data.sort((a,b) => (a.score - b.score));

function compare(a, b){
    return a.score - b.score;
}
console.log(data);