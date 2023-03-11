abstract class Animal {}

class Cachorro extends Animal {
  nome: string;
  raca: string;
  idade: number;
  sexo: string;
  peso: number;
  tutor: string;

  constructor(
    nome: string,
    raca: string,
    idade: number,
    sexo: "macho" | "fêmea",
    peso: number,
    tutor: string
  ) {
    super();
    this.nome = nome;
    this.raca = raca;
    this.idade = idade;
    this.sexo = sexo;
    this.peso = peso;
    this.tutor = tutor;

    this.apresentar();
  }

  apresentar() {
    console.log(
      `Nome: ${this.nome}\nRaça: ${this.raca} \nIdade: ${this.idade} \nSexo: ${this.sexo} \nPeso: ${this.peso}kg \nTutor/a: ${this.tutor}\n`
    );
  }
}

const toto: Animal = new Cachorro(
  "Totó",
  "vira-lata",
  2,
  "fêmea",
  3.6,
  "Dorory"
);

const lassie: Animal = new Cachorro(
  "Lassie",
  "collie",
  14,
  "fêmea",
  24.2,
  "Rudd"
);
