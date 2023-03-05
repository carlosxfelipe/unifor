const mesPorExtenso = [
  "janeiro",
  "fevereiro",
  "março",
  "abril",
  "maio",
  "junho",
  "julho",
  "agosto",
  "setembro",
  "outubro",
  "novembro",
  "dezembro",
];

const exibirDataPorExtenso = (dataEmString) => {
  const [dia, mes, ano] = dataEmString.split("/");
  console.log(`${dia} de ${mesPorExtenso[Number(mes) - 1]} de ${ano}`);
};

exibirDataPorExtenso("12/10/1998");
