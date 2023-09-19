const input = require("fs").readFileSync("stdin", "utf8");
const lines = input.split("\n");

const ehPrimo = (number) => {
  if (number <= 1) return false;

  for (let i = 2; i <= number ** 0.5; i++) {
    if (number % i === 0) {
      return false; // encontrou um divisor
    }
  }
  return true;
};

const exibeReverso = (array) => {
  array.sort((a, b) => b - a);
  return array;
};

const insereOrdenado = (array) => {
  array.sort((a, b) => a - b);
  return array;
};

const arrayNumeros = lines.map(Number).filter((numero) => numero > 0);
const primos = [];
const naoPrimos = [];

arrayNumeros.forEach((numero) => {
  if (ehPrimo(numero)) {
    primos.push(numero);
  } else {
    naoPrimos.push(numero);
  }
});

const primosOrdemCrescente = insereOrdenado(primos);
const primosOrdemDecrescente = exibeReverso(naoPrimos);

if (primos.length === 0 || naoPrimos.length === 0) {
  console.log("Uma das estruturas está vazia!");
} else {
  for (const primo of primosOrdemCrescente) {
    console.log(primo);
  }
  console.log("-");
  for (const naoPrimo of primosOrdemDecrescente) {
    console.log(naoPrimo);
  }
}
