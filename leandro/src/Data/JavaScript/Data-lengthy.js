const mesPorExtenso = (codigoDoMes) => {
  switch (codigoDoMes) {
    case "01":
      return "janeiro";
    case "02":
      return "fevereiro";
    case "03":
      return "março";
    case "04":
      return "abril";
    case "05":
      return "maio";
    case "06":
      return "junho";
    case "07":
      return "julho";
    case "08":
      return "agosto";
    case "09":
      return "setembro";
    case "10":
      return "outubro";
    case "11":
      return "novembro";
    case "12":
      return "dezembro";
  }
};

const extrairAno = (dataEmString) => {
  const ano = dataEmString.split("/");
  return ano[2];
};

const extrairMes = (dataEmString) => {
  const mes = dataEmString.split("/");
  return mesPorExtenso(mes[1]);
};

const extrairDia = (dataEmString) => {
  const dia = dataEmString.split("/");
  return dia[0];
};

const exibirDataPorExtenso = (valorDigitado) => {
  if (
    (valorDigitado[2] !== "/" && valorDigitado[6] !== "/") ||
    valorDigitado.length !== 10
  ) {
    console.log("A data precisa ser DD/MM/AAAA");
  } else
    console.log(
      `${extrairDia(valorDigitado)} de ${extrairMes(
        valorDigitado
      )} de ${extrairAno(valorDigitado)}`
    );
  return;
};

exibirDataPorExtenso("12/10/1998");
