const fs = require("fs");
const input = fs.readFileSync("input.txt", "utf8");

let goalCount = 0;

input.split("\n").forEach(line => {
    let lineSplit = line.split(",");

    let firstHalf = lineSplit[0].split("-").map(item => parseInt(item, 10))
    let secondHalf = lineSplit[1].split("-").map(item => parseInt(item, 10))

    if (firstHalf[0] <= secondHalf[0] && firstHalf[1] >= secondHalf[1] || firstHalf[0] >= secondHalf[0] && firstHalf[1] <= secondHalf[1]) {
        goalCount++;
    }
})

console.log(goalCount)

