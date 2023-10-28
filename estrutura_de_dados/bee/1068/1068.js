/* const input = require("fs").readFileSync("./dev/stdin", "utf8"); */
const input = require("fs").readFileSync("/dev/stdin", "utf8");
const lines = input.trim().split("\n");

while (lines.length) {
  const expression = lines.shift().trim();

  let i = 0;
  let parentheses = 0;

  for (i = 0; i < expression.length; ++i) {
    if (expression[i] === "(") {
      parentheses += 1;
    } else if (expression[i] === ")") {
      if (parentheses > 0) parentheses -= 1;
      else break;
    }
  }

  if (i === expression.length && parentheses === 0) {
    console.log("correct");
  } else {
    console.log("incorrect");
  }
}
