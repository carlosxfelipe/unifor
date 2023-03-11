export class Questao {
  private _enunciado: string;
  private _alternativas: string[];
  private _resposta: string;

  constructor(enunciado: string, alternativas: string[], resposta: string) {
    this._enunciado = enunciado;
    this._alternativas = alternativas;
    this._resposta = resposta;
  }

  public apresentar(): void {
    console.log();
    console.log(`Questão: ${this._enunciado}`);
    for (let i = 0; i < this._alternativas.length; i++) {
      const letra = String.fromCharCode(97 + i);
      console.log(`${letra}) ${this._alternativas[i]}`);
    }
  }

  public responder(respostaUsuario: "a" | "b" | "c" | "d"): any {
    if (respostaUsuario === this._resposta) {
      console.log("Resposta correta!");
    } else {
      console.log(`Resposta incorreta!\nLetra correta: ${this._resposta}`);
    }
  }
}
