public class Questao {

  private String pergunta;
  private String[] opcoes;
  private String gabarito;

  public Questao(String pergunta, String[] opcoes, String gabarito) {
    this.pergunta = pergunta;
    this.opcoes = opcoes;
    this.gabarito = gabarito;
  }

  public void apresentar() {
    System.out.println(pergunta);
    for (int i = 0; i < opcoes.length; i++) {
      System.out.println((char) ('a' + i) + ") " + opcoes[i]);
    }
  }

  public void responder(String resposta) {
    if (resposta.equalsIgnoreCase(gabarito)) {
      System.out.println("Parabéns, você acertou!");
    } else {
      System.out.println("Ops, resposta incorreta...");
    }
  }
}
