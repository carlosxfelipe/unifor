import java.util.Scanner;

public class Perguntas {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Questao questao1 = new Questao(
      "Quanto é 2 + 2?",
      new String[] { "3", "4", "5", "6" },
      "b"
    );
    questao1.apresentar();
    String resposta1 = scanner.nextLine();
    questao1.responder(resposta1);

    Questao questao2 = new Questao(
      "Quem descobriu o Brasil?",
      new String[] {
        "Pedro Álvares Cabral",
        "Vicente Pinzón",
        "Duarte Pacheco Pereira",
        "Cristóvão Colombo",
      },
      "a"
    );
    questao2.apresentar();
    String resposta2 = scanner.nextLine();
    questao2.responder(resposta2);

    scanner.close();
  }
}
