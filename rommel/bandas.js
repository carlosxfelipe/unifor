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

// Divide o array "input" em um array de objetos "dados"
const dados = [];
let tmp = {};
for (let i = 0; i < input.length; i++) {
  if (i % 5 === 0 || i === 0) {
    tmp = { ...tmp, banda: input[i] };
  }
  if (i % 5 === 1 || i === 1) {
    tmp = { ...tmp, tipo: input[i] };
  }
  if (i % 5 === 2 || i === 2) {
    tmp = { ...tmp, integrantes: input[i] };
  }
  if (i % 5 === 3 || i === 3) {
    tmp = { ...tmp, lucro: input[i] };
  }
  if (i % 5 === 4 || i === 4) {
    tmp = { ...tmp, shows: input[i] };
    dados.push(tmp);
    tmp = {};
  }
}

// A quantidade de bandas que tem exatamente cinco integrantes
const cincoIntegrantes = dados
  .filter((item) => item.integrantes === 5)
  .map((item) => item.banda);

console.log(
  `Bandas que tem exatamente cinco integrantes: ${cincoIntegrantes
    .toString()
    .replace(",", ", ")}.`
);

// A quantidade de bandas do tipo Indie
const bandasIndie = dados
  .filter((item) => item.tipo.toLowerCase() === "indie")
  .map((item) => item.banda);

console.log(
  `Bandas do tipo Indie: ${bandasIndie.toString().replace(",", ", ")}.`
);

// O maior lucro obtido por uma banda
const valores = dados.map((item) => item.lucro);
const maiorValor = Math.max(...valores);
const indiceMaiorValor = valores.indexOf(maiorValor);

console.log(
  `O maior lucro obtido foi ${maiorValor.toLocaleString("pt-br", {
    style: "currency",
    currency: "BRL",
  })} pela banda ${dados[indiceMaiorValor].banda}.`
);

// O menor lucro obtido por uma banda
const menorValor = Math.min(...valores);
const indiceMenorValor = valores.indexOf(menorValor);

console.log(
  `O menor lucro obtido foi ${menorValor.toLocaleString("pt-br", {
    style: "currency",
    currency: "BRL",
  })} pela banda ${dados[indiceMenorValor].banda}.`
);

// O nome da banda, que contém um único integrante, que obteve o maior lucro
const unicoIntegrante = dados.filter((item) => item.integrantes === 1);
const valoresUnicoIntegrante = unicoIntegrante.map((item) => item.lucro);
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
  )} pelo músico ${dados[indiceMaiorValorUnicoIntegrante].banda}.`
);

// O nome da banda que fez menos shows
const showsTmp = dados.map((item) => item.shows);
const menosShows = Math.min(...showsTmp);
const indiceMenosShows = showsTmp.indexOf(menosShows);

console.log(
  `A banda ${dados[indiceMenosShows].banda} foi a que fez menos shows, apenas ${menosShows} apresentações.`
);

// A soma dos integrantes das bandas
const integrantesTmp = dados.map((item) => item.integrantes);
const somaDosIntegrantes = integrantesTmp.reduce(
  (anterior, atual) => {
    return { total: anterior.total + atual };
  },
  { total: 0 }
);

console.log(`A soma dos integrantes das bandas é ${somaDosIntegrantes.total}.`);

// A quantidade de bandas que possuem mais de um integrante e fizeram mais que 33 shows
const maisDeUmIntegrante33shows = dados
  .filter((item) => item.integrantes > 1)
  .filter((item) => item.shows > 33)
  .map((item) => item.banda);

console.log(
  `A(s) banda(s) que possuem mais de um integrante e fizeram mais que 33 shows são ${
    maisDeUmIntegrante33shows.length
  }: ${maisDeUmIntegrante33shows.toString().replace(",", ", ")}.`
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
