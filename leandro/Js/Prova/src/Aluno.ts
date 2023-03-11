export class Aluno {
  private _nome: string;
  private _matricula: number;

  constructor(nome: string, matricula: number) {
    this._nome = nome;
    this._matricula = matricula;
  }

  public apresentar(): void {
    console.log(`Nome: ${this._nome}, Matrícula: ${this._matricula}`);
  }

  private aprovar(): void {
    console.log(`${this._nome} aprovado!`);
  }

  get nome(): string {
    return this._nome;
  }

  set nome(nome: string) {
    this._nome = nome;
  }

  get matricula(): number {
    return this._matricula;
  }

  set matricula(matricula: number) {
    this._matricula = matricula;
  }
}
