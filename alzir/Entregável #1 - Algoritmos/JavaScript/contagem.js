const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let numeros = [];

const obterInteiros = (numeros) => {
  const inteiros = numeros.filter((item) => item % 1 === 0 && item > 0);
  return console.log(inteiros.length, inteiros);
};

const obterNumero = (quantidade) => {
  readline.question(
    `Digite o número (${numeros.length + 1} de ${quantidade}): `,
    (numero) => {
      numeros.push(numero);

      if (quantidade <= numeros.length) {
        readline.close();
        obterInteiros(numeros);
      } else {
        obterNumero(quantidade);
      }
    }
  );
};

readline.question("Digite a quantidade de números: ", (quantidade) => {
  if (isNaN(quantidade)) {
    console.log("Você não digitou um número!");
    readline.close();
  } else obterNumero(quantidade);
});
