let arr = [1,3,5,7,9,11,13,15,17,19];
//찾을 값
let target = 19;
// bS(배열,left, right, 찾을값);
let searchIndex=binarySerch(arr, 0, arr.length-1, target);

if(searchIndex == -1){
    console.log(`찾는 값 : ${target}은 없습니다.`)
} else {
    console.log(`찾는 값 : ${target}, 인덱스 : ${searchIndex}`)
}

function binarySerch(arr, left, right, target){
    if(left > right) return -1;
    let mid = parseInt((left+right)/2);
    // 찾은 경우
    if(arr[mid]==target) {
        return mid;}
    else if(arr[mid] > target){
        // 찾는 값이 배열의 좌측에 있는 경우
        return binarySerch(arr, left, mid-1, target);
    } else {
        // 찾는 값이 배열의 우측에 있는 경우
        return binarySerch(arr, mid+1, right, target);
    }
}