let data = [8, 4, 6, 1, 2, 5, 7, 3];
// 병합정렬될 임시 배열
let sorted = [];

// 머지소트 호출
mergeSort(data, 0, data.length-1);
// 결과 출력하기
console.log('result : ' + data);

// 머지소트 정의
function mergeSort(arr, left, right){
    if(left < right){
        // 중간 인덱스 구하기
        let mid = parseInt((left+right)/2);
        // 배열의 왼쪽 쪼개기
        mergeSort(arr, left, mid);
        // 배열의 오른쪽 쪼개기
        mergeSort(arr, mid+1, right);
        // 병합처리
        merge(arr, left, mid, right);
    }
}

// 병합처리 함수 구현
function merge(arr, left, mid, right){
    let i = left;
    let j = mid + 1;
    // 병합할 배열의 인덱스
    let k = left;

    while(i <= mid && j <= right){
        if(arr[i] <= arr[j]){
            // 앞쪽 배열값이 작은 경우
            sorted[k] = arr[i];
            k++;
            i++;
        } else {
            // 뒷쪽 배열값이 작은 경우
            sorted[k++] = arr[j++];
            // k++;
            // j++;
        }
    }
    // 왼쪽이 끝난경우
    if(i > mid){
        for(; j <= right; j++){
            sorted[k] = arr[j];
            k++;
        }
    } else {
        // 오른쪽이 끝난 경우
        for(; i <= mid; i++){
            sorted[k] = arr[i];
            k++;
        }
    }
    // 두개의 배열이 하나로 합쳐짐.(sorted)
    // sorted 배열의 내용을 arr에다가 update
    for(let x = left; x <= right; x++){
        arr[x] = sorted[x];
    }
    console.log('sorted : ' + sorted);
}