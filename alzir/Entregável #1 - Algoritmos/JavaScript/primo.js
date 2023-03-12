const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

readline.question("Digite um número n: ", (num) => {
  if (num <= 0) {
    console.log("Digite um número inteiro positivo!");
  } else {
    let divisores = 0;

    for (let cont = 1; cont <= num; cont++) if (num % cont == 0) divisores++;

    if (divisores === 2) console.log(`${Number(num)} é número primo!`);
    else console.log(`${Number(num)} não é número primo!`);
  }
  readline.close();
});
