function countByRange(arr, left, right){
    let rightIndex = upperBound(arr, right, 0, arr.length);
    let leftIndex = lowerBound(arr, left, 0, arr.length);
    return rightIndex - leftIndex;
}

let arr = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9];
// 값이 4인 데이터 개수 출력
console.log(countByRange(arr, 4, 4));
// 값이 [-1, 3] 범위의 갯수 출력
console.log(countByRange(arr, -1, 3));

function lowerBound(arr, target, start, end){
    while(start < end){
        let mid = parseInt((start+end)/2);
        if(arr[mid] >= target) end = mid;
        else start = mid + 1;
    }
    return end;
}

function upperBound(arr, target, start, end){
    while(start < end){
        let mid = parseInt((start+end)/2);
        if(arr[mid] > target) end = mid;
        else start = mid + 1;
    }
    return end;
}