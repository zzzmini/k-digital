let fs = require('fs');
let input = fs.readFileSync('07_01_exam.txt').toString().split('\n');

let [n, m] = input[0].split(' ').map(Number);
// n = 4, m = 2
let arr = [];
for(let i = 1; i<=n ; i++){
    arr.push(i);
}

let visited = new Array(n).fill(false);
let selected = [];

let answer = '';
function dfs(arr, depth){
    if(depth == m){
        let result = [];
        for(let i of selected){
            result.push(arr[i]);
        }
        for(let x of result){
            answer += x + ' ';
        }
        answer += '\n';
        return;
    }
    for(let i=0; i<arr.length; i++){
        if(visited[i]) continue;
        selected.push(i);
        visited[i] = true;
        dfs(arr, depth+1);
        selected.pop();
        visited[i] = false;
    }
}

dfs(arr, 0);
console.log(answer);