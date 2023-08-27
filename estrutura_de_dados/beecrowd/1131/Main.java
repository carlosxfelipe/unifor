import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int grenais = 0;
    int vitoriasInter = 0;
    int vitoriasGremio = 0;
    int empates = 0;

    while (true) {
      int golsInter = scanner.nextInt();
      int golsGremio = scanner.nextInt();

      if (golsInter > golsGremio) {
        vitoriasInter++;
      } else if (golsGremio > golsInter) {
        vitoriasGremio++;
      } else {
        empates++;
      }

      grenais++;

      System.out.println("Novo grenal (1-sim 2-nao)");
      int resposta = scanner.nextInt();
      if (resposta == 2) {
        break;
      }
    }

    scanner.close();

    System.out.println(grenais + " grenais");
    System.out.println("Inter:" + vitoriasInter);
    System.out.println("Gremio:" + vitoriasGremio);
    System.out.println("Empates:" + empates);

    if (vitoriasInter > vitoriasGremio) {
      System.out.println("Inter venceu mais");
    } else if (vitoriasGremio > vitoriasInter) {
      System.out.println("Gremio venceu mais");
    } else {
      System.out.println("Nao houve vencedor");
    }
  }
}
