const input = require("fs").readFileSync("stdin", "utf8");
const lines = input.split("\n");

class No {
  constructor(value) {
    this.value = value;
    this.proximo = null;
  }
}

class Lista {
  constructor() {
    this.comeco = null;
  }

  insereOrdenado(value) {
    const novoNo = new No(value);

    if (!this.comeco || value < this.comeco.value) {
      novoNo.proximo = this.comeco;
      this.comeco = novoNo;
      return;
    }

    let atual = this.comeco;
    while (atual.proximo && value > atual.proximo.value) {
      atual = atual.proximo;
    }

    novoNo.proximo = atual.proximo;
    atual.proximo = novoNo;
  }

  exibeReverso() {
    const arrayReverso = [];
    let atual = this.comeco;
    while (atual) {
      arrayReverso.unshift(atual.value);
      atual = atual.proximo;
    }
    return arrayReverso;
  }
}

const ehPrimo = (number) => {
  if (number <= 1) return false;

  for (let i = 2; i <= number ** 0.5; i++) {
    if (number % i === 0) {
      return false; // tem divisor
    }
  }
  return true;
};

const primos = new Lista();
const naoPrimos = new Lista();

const arrayNumeros = lines.map(Number).filter((numero) => numero > 0);

arrayNumeros.forEach((numero) => {
  if (ehPrimo(numero)) {
    primos.insereOrdenado(numero);
  } else {
    naoPrimos.insereOrdenado(numero);
  }
});

const primosOrdemDecrescente = naoPrimos.exibeReverso();

if (!primos.comeco || !primosOrdemDecrescente.length) {
  console.log("Uma das estruturas está vazia!");
} else {
  let atual = primos.comeco; // ordem crescente
  while (atual) {
    console.log(atual.value);
    atual = atual.proximo;
  }
  console.log("-");
  for (const naoPrimo of primosOrdemDecrescente) {
    console.log(naoPrimo);
  }
}
