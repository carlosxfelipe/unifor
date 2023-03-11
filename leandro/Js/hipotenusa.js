const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const hipotenusa = (a, b) => {
  console.log(`A hipotenusa de ${a} e ${b} é ${(a ** 2 + b ** 2) ** 0.5}`);
};

readline.question("Digite o valor de a: ", (a) => {
  readline.question("Digite o valor de b: ", (b) => {
    readline.close();
    hipotenusa(a, b);
  });
});
