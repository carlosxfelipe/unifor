const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const somar = (a, b) => Number(a) + Number(b);
const subtrair = (a, b) => a - b;
const multiplicar = (a, b) => a * b;
const dividir = (a, b) => a / b;

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

  if (operador === "+") console.log(somar(a, b));
  if (operador === "-") console.log(subtrair(a, b));
  if (operador === "*") console.log(multiplicar(a, b));
  if (operador === "/") console.log(dividir(a, b));
};

readline.question(
  "Digite a operação matemática com dois valores: ",
  (input) => {
    readline.close();
    calcular(input.replace(/\s{2,}/g, " ").trim());
  }
);
