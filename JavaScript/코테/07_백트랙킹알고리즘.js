let n = 8;
let queens = [];

function possible(x, y){
    for(let [a, b] of queens){
        if(a == x || b == y) return false;
        if(Math.abs(a - x) == Math.abs(b - y)) return false;
    }
    return true;
}

let cnt = 0;
function dfs(row){
    if (row == n) cnt += 1;
    for(let i = 0; i < n; i++){
        if(!possible(row, i)) continue;
        queens.push([row, i]);
        dfs(row + 1);
        queens.pop();
    }
}

dfs(0);
console.log(cnt);