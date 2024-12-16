function binarySearch(arr, target, start, end){
    if(start > end) return -1;
    let mid = parseInt((start + end)/2);
    // 찾은 경우 중간점 찾기
    if(arr[mid] == target) return mid;
    // 중간점 보다 찾는값이 적은 경우
    else if(arr[mid] > target) {
        return binarySearch(arr, target, start, mid-1);
    // 중간점 보다 찾는값이 큰 경우
    } else {
        return binarySearch(arr, target, mid+1, end);
    }
}

let n =10;
let target = 7;
arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];
// 이진탐색 호출
let result = binarySearch(arr, target, 0, n-1);
if(result == -1) console.log('찾는 값이 없습니다.');
else console.log(`${result+1}번째에 있습니다.`)