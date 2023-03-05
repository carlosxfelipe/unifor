const alunos = [
  { aluno: "João", nota: 67 },
  { aluno: "Carlos", nota: 77 },
  { aluno: "Pedro", nota: 84 },
  { aluno: "Amanda", nota: 40 },
  { aluno: "Ana", nota: 56 },
  { aluno: "Felipe", nota: 64 },
  { aluno: "Vanessa", nota: 32 },
  { aluno: "Paulo", nota: 100 },
];

const aprovados = alunos
  .filter((item) => item.nota > 50)
  .map((item) => item.aluno);

const posicao = alunos.filter((item) => item.nota > 50);

console.log(
  `O total de alunos aprovados foi: ${aprovados
    .toString()
    .replaceAll(",", ", ")}`
);
