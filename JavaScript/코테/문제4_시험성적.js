let fs = require("fs");
let input = fs.readFileSync('문제4_시험성적.txt').toString().split("\n");

let score = parseInt(input[0]);
if (score>=90) console.log("A");
else if (score>=80) console.log("B");
else if (score>=70) console.log("C");
else if (score>=60) console.log("D");
else console.log("F");