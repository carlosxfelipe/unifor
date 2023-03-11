import { Aluno } from "./Aluno";
import { Questao } from "./Questao";

const alunos: Aluno[] = [
  new Aluno("Carlos", 12345),
  new Aluno("Felipe", 23456),
  new Aluno("Caio", 34567),
];

for (const aluno of alunos) {
  aluno.apresentar();
}

const questao1 = new Questao("Quanto é 2 + 2?", ["3", "4", "5", "6"], "b");
questao1.apresentar();
questao1.responder("b");

const questao2 = new Questao(
  "Quem descobriu o Brasil?",
  [
    "Pedro Álvares Cabral",
    "Vicente Pinzón",
    "Duarte Pacheco Pereira",
    "Cristóvão Colombo",
  ],
  "a"
);
questao2.apresentar();
questao2.responder("d");
