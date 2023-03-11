const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let numeros = [];

const ordenar = (arr) => {
  if (arr.length <= 1) {
    return arr;
  }

  const pivo = arr[0];
  const esquerda = [];
  const direita = [];

  for (let i = 1; i < arr.length; i++) {
    arr[i] < pivo ? esquerda.push(arr[i]) : direita.push(arr[i]);
  }

  return ordenar(esquerda).concat(pivo, ordenar(direita));
};

const perguntar = (quantidade) => {
  readline.question(
    `Digite o número (${numeros.length + 1} de ${quantidade}): `,
    (numero) => {
      numeros.push(numero);

      if (quantidade <= numeros.length) {
        readline.close();
        /* console.log(numeros.sort()); */
        console.log(ordenar(numeros));
      } else {
        perguntar(quantidade);
      }
    }
  );
};

readline.question("Digite a quantidade de números: ", (quantidade) => {
  if (isNaN(quantidade)) {
    console.log("Digite um número!");
    readline.close();
  } else perguntar(quantidade);
});
