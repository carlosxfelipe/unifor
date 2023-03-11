const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let numeros = [];

const somar = (numeros) => {
  const soma = numeros.reduceRight(function (ultimoValor, penultimoValor) {
    return Number(ultimoValor) + Number(penultimoValor);
  });
  console.log(`O somatório é ${soma}`);
};

const perguntar = (quantidade) => {
  readline.question(
    `Digite o número (${numeros.length + 1} de ${quantidade}): `,
    (numero) => {
      numeros.push(numero);

      if (quantidade <= numeros.length) {
        readline.close();
        somar(numeros);
      } else {
        perguntar(quantidade);
      }
    }
  );
};

readline.question("Digite a quantidade de números: ", (quantidade) => {
  if (isNaN(quantidade)) {
    console.log("Digite um número inteiro positivo!");
    readline.close();
  } else perguntar(quantidade);
});
