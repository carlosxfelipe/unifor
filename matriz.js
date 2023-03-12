const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const randomNum = (min, max) =>
  Math.floor(Math.random() * (max - -max + 1)) - max + min;

const formatar = (num, length) => {
  if (num >= 0) {
    return " " + num.toString().padStart(length, "0");
  } else {
    return num.toString().padEnd(length + 1, " ");
  }
};

readline.question("Qual o número de linhas da matriz? ", (rows) => {
  readline.question("Qual o número de colunas da matriz? ", (cols) => {
    readline.question("Qual o número máximo a ser gerado? ", (max) => {
      const maxNumber = parseInt(max);
      const digits = maxNumber.toString().length;
      const matriz = Array.from({ length: rows }, () =>
        Array.from({ length: cols }, () =>
          formatar(randomNum(0, maxNumber), digits)
        )
      );
      console.log("Matriz criada:");
      matriz.forEach((row) => console.log(`[${row.join(" ")}]`));
      readline.close();
    });
  });
});
