// 서로 다른 30000 개 배열 생성
let data = Array.from({length:30000}, 
    ()=> Math.floor(Math.random()*1000));
startTime = new Date().getTime();
bubble(data);
endTime = new Date().getTime();
console.log('버블소트 소요시간 : ' , endTime - startTime , 'ms');

// 값이 7인 30000개 담은 배열 생성
data = Array.from({length:30000}, () => 7);
startTime = new Date().getTime();
bubble(data);
endTime = new Date().getTime();
console.log('버블소트 소요시간 : ' , endTime - startTime , 'ms');

function bubble(data){
    for(let i=0; i<data.length-1; i++){
        for(let j = 0 ; j<data.length -i ; j++){
            if(data[j] > data[j+1]){
                swap(j, j+1);
            }
        }
    }
}

function swap(i, j){
    let temp = data[i];
    data[i] = data[j];
    data[j] = temp;
}