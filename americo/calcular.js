const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const somar = (a, b) => a + b;
const multiplicar = (a, b) => a * b;
const dividir = (a, b) => a / b;
const subtrair = (a, b) => a - b;

const calcular = (input) => {
  let [a, operador, b] = input.split(" ");

  if (isNaN(a) || isNaN(b)) {
    console.log("Os valores devem ser números!");
    return;
  }

  const operadoresValidos = ["+", "-", "*", "/"];
  if (!operadoresValidos.includes(operador)) {
    console.log(
      "Operadores matemáticos válidos: \n+ Adição \n- Subtração \n* Multiplicação \n/ Divisão"
    );
    return;
  }

  if (operador === "+") console.log(somar(Number(a), Number(b)));
  if (operador === "*") console.log(multiplicar(Number(a), Number(b)));
  if (operador === "/") console.log(dividir(Number(a), Number(b)));
  if (operador === "-") console.log(subtrair(Number(a), Number(b)));
};

readline.question(
  "Digite a operação matemática com dois valores: ",
  (input) => {
    readline.close();
    calcular(input);
  }
);
