const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const hipotenusa = (a, b) => {
  const pitagoras = (a ** 2 + b ** 2) ** 0.5;

  console.log(
    `A hipotenusa de ${Number(a)} e ${Number(b)} é ${pitagoras.toFixed(1)}`
  );
};

readline.question("Digite o valor de a: ", (a) => {
  readline.question("Digite o valor de b: ", (b) => {
    readline.close();
    hipotenusa(a, b);
  });
});
