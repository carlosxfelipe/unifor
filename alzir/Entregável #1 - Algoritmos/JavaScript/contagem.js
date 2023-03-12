const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let numeros = [];

const filtrar = (numeros) => {
  const inteiros = numeros.filter((item) => item % 1 === 0 && item > 0);
  return console.log(inteiros.length, inteiros);
};

const perguntar = (quantidade) => {
  readline.question(
    `Digite o número (${numeros.length + 1} de ${quantidade}): `,
    (numero) => {
      numeros.push(Number(numero));

      if (quantidade <= numeros.length) {
        readline.close();
        filtrar(numeros);
      } else {
        perguntar(quantidade);
      }
    }
  );
};

readline.question("Digite a quantidade de números: ", (quantidade) => {
  if (isNaN(quantidade) || quantidade <= 0) {
    console.log("Digite um número inteiro positivo!");
    readline.close();
  } else perguntar(quantidade.trim());
});
