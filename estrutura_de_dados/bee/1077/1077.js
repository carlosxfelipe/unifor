// const input = require("fs").readFileSync("./dev/stdin", "utf8");
const input = require("fs").readFileSync("/dev/stdin", "utf8");
const lines = input.trim().split("\n");

const infixToPostfix = (expression) => {
  const precedence = {
    "^": 3,
    "*": 2,
    "/": 2,
    "+": 1,
    "-": 1,
  };

  const operators = "+-*/^";
  const isOperator = (char) => operators.includes(char);

  const isAlphaNumeric = (char) => {
    return (
      (char >= "a" && char <= "z") ||
      (char >= "A" && char <= "Z") ||
      (char >= "0" && char <= "9")
    );
  };

  const infixToPostfixSingle = (expression) => {
    const stack = [];
    const output = [];

    for (let i = 0; i < expression.length; i++) {
      const token = expression[i];

      if (isAlphaNumeric(token)) {
        output.push(token);
      } else if (token === "(") {
        stack.push(token);
      } else if (token === ")") {
        while (stack.length > 0 && stack[stack.length - 1] !== "(") {
          output.push(stack.pop());
        }
        stack.pop();
      } else if (isOperator(token)) {
        while (
          stack.length > 0 &&
          stack[stack.length - 1] !== "(" &&
          precedence[token] <= precedence[stack[stack.length - 1]]
        ) {
          output.push(stack.pop());
        }
        stack.push(token);
      }
    }

    while (stack.length > 0) {
      output.push(stack.pop());
    }

    return output.join("");
  };

  const numCases = parseInt(lines[0], 10);

  for (let i = 1; i <= numCases; i++) {
    console.log(infixToPostfixSingle(lines[i]));
  }
};

infixToPostfix(lines);
