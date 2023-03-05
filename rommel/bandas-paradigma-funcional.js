const input = [
  "Los Hermanos",
  "Indie",
  4,
  58000,
  31,
  "Ed Sheeran",
  "Folk",
  1,
  47000,
  29,
  "Lenine",
  "MPB",
  1,
  32000,
  15,
  "Oasis",
  "Rock",
  5,
  62000,
  45,
  "Rubel",
  "Folk",
  1,
  33000,
  20,
  "Aerosmith",
  "Rock",
  5,
  42000,
  34,
];

const dadosBandas = [];
let tmp = {};
for (let i = 0; i < input.length; i++) {
  if (i % 5 === 0 || i === 0) {
    tmp = { ...tmp, nomeDaBanda: input[i] };
  }
  if (i % 5 === 1 || i === 1) {
    tmp = { ...tmp, tipo: input[i] };
  }
  if (i % 5 === 2 || i === 2) {
    tmp = { ...tmp, numeroDeIntegrantes: input[i] };
  }
  if (i % 5 === 3 || i === 3) {
    tmp = { ...tmp, lucroNaUltimaTurne: input[i] };
  }
  if (i % 5 === 4 || i === 4) {
    tmp = { ...tmp, quantidadeDeShows: input[i] };
    dadosBandas.push(tmp);
    tmp = {};
  }
}

// A quantidade de bandas que tem exatamente cinco integrantes
const cincoIntegrantes = dadosBandas
  .filter((item) => item.numeroDeIntegrantes === 5)
  .map((item) => item.nomeDaBanda);

console.log(
  `Bandas que tem exatamente cinco integrantes: ${cincoIntegrantes
    .toString()
    .replace(",", ", ")}.`
);

// A quantidade de bandas do tipo Indie
const bandasIndie = dadosBandas
  .filter((item) => item.tipo.toLowerCase() === "indie")
  .map((item) => item.nomeDaBanda);

console.log(
  `Bandas do tipo Indie: ${bandasIndie.toString().replace(",", ", ")}.`
);

// O maior lucro obtido por uma banda
const valores = dadosBandas.map((item) => item.lucroNaUltimaTurne);
const maiorValor = Math.max(...valores);
const indiceMaiorValor = valores.indexOf(maiorValor);

console.log(
  `O maior lucro obtido foi ${maiorValor.toLocaleString("pt-br", {
    style: "currency",
    currency: "BRL",
  })} pela banda ${dadosBandas[indiceMaiorValor].nomeDaBanda}.`
);

// O menor lucro obtido por uma banda
const menorValor = Math.min(...valores);
const indiceMenorValor = valores.indexOf(menorValor);

console.log(
  `O menor lucro obtido foi ${menorValor.toLocaleString("pt-br", {
    style: "currency",
    currency: "BRL",
  })} pela banda ${dadosBandas[indiceMenorValor].nomeDaBanda}.`
);

// O nome da banda, que contém um único integrante, que obteve o maior lucro
const unicoIntegrante = dadosBandas.filter(
  (item) => item.numeroDeIntegrantes === 1
);
const valoresUnicoIntegrante = unicoIntegrante.map(
  (item) => item.lucroNaUltimaTurne
);
const maiorValorUnicoIntegrante = Math.max(...valoresUnicoIntegrante);
const indiceMaiorValorUnicoIntegrante = valores.indexOf(
  maiorValorUnicoIntegrante
);

console.log(
  `O maior lucro obtido por um único integrante foi ${maiorValorUnicoIntegrante.toLocaleString(
    "pt-br",
    {
      style: "currency",
      currency: "BRL",
    }
  )} pelo músico ${dadosBandas[indiceMaiorValorUnicoIntegrante].nomeDaBanda}.`
);

// O nome da banda que fez menos shows
const shows = dadosBandas.map((item) => item.quantidadeDeShows);
const menosShows = Math.min(...shows);
const indiceMenosShows = shows.indexOf(menosShows);

console.log(
  `A banda ${dadosBandas[indiceMenosShows].nomeDaBanda} foi a que fez menos shows, apenas ${menosShows} apresentações.`
);

// A soma dos integrantes das bandas
const integrantes = dadosBandas.map((item) => item.numeroDeIntegrantes);
const somaDosIntegrantes = integrantes.reduce(
  (anterior, atual) => {
    return { total: anterior.total + atual };
  },
  { total: 0 }
);

console.log(`A soma dos integrantes das bandas é ${somaDosIntegrantes.total}.`);

// A quantidade de bandas que possuem mais de um integrante e fizeram mais que 33 shows
const maisDeUmIntegranteEMaisDe33shows = dadosBandas
  .filter((item) => item.numeroDeIntegrantes > 1)
  .filter((item) => item.quantidadeDeShows > 33)
  .map((item) => item.nomeDaBanda);

console.log(
  `A(s) banda(s) que possuem mais de um integrante e fizeram mais que 33 shows são ${
    maisDeUmIntegranteEMaisDe33shows.length
  }: ${maisDeUmIntegranteEMaisDe33shows.toString().replace(",", ", ")}.`
);

// A média do lucro
const fnMedia = (anterior, atual) => {
  const novaQtde = anterior.qtde + 1;
  const novoTotal = anterior.total + atual;

  return { qtde: novaQtde, total: novoTotal, media: novoTotal / novaQtde };
};
const mediaDoLucro = valores.reduce(fnMedia, { qtde: 0, total: 0, media: 0 });

console.log(
  `A média do lucro foi ${mediaDoLucro.media.toLocaleString("pt-br", {
    style: "currency",
    currency: "BRL",
  })}`
);
