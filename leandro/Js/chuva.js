const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const converter = (quantidade) =>
  console.log(
    `${quantidade} polegadas de chuva em mm é ${(
      quantidade * 25.4
    ).toLocaleString("pt-BR")}`
  );

readline.question(
  "Digite a quantidade de chuva em polegadas: ",
  (quantidade) => {
    readline.close();
    converter(quantidade);
  }
);
