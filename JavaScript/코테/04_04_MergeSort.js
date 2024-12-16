let fs = require('fs');
input = fs.readFileSync('sort.txt').toString().split('\n');
let data = input[0].split(' ').map(Number);

console.log('source = ' + data);
let sorted = [];

mergeSort(data, 0, data.length-1);
console.log('result = ' + data);

function mergeSort(arr, left, right){
    // 원소 1개 인 경우
    if(left < right){
        //원소 2개 이상
        let mid = parseInt((left+right)/2);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        myMerge(arr, left, mid, right);
    }
}

function myMerge(arr, left, mid, right){
    let i = left;
    let j = mid + 1;
    let k = left;  // 결과 배열의 첫 인덱스

    while(i<=mid && j <= right){
        if(arr[i] <= arr[j]){
            sorted[k++] = arr[i++];
        } else {
            sorted[k++] = arr[j++];
        }
    }
    // 왼쪽 배열 처리 끝
    if(i > mid){
        for(; j <= right; j++){
            sorted[k++] = arr[j]
        }
    }
    // 오른쪽 배열 처리 끝
    else{
        for(; i <= mid; i++){
            sorted[k++] = arr[i];
        }
    }
    // 정렬결과 원본 반영
    for(let x = left; x <= right; x++){
        arr[x] = sorted[x];
    }
    console.log('sorted : ' + sorted);
}