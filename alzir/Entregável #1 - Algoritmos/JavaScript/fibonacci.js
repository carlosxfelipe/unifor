const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const fibonacci = (num) => {
  if (num < 2) {
    return num;
  } else {
    return fibonacci(num - 1) + fibonacci(num - 2);
  }
};

readline.question("Digite um número: ", (n) => {
  if (n <= 0 || isNaN(n)) {
    console.log("Digite um número inteiro positivo!");
  } else {
    for (let i = 0; i < n; i++) {
      readline.close();
      console.log(fibonacci(i));
    }
  }
});
