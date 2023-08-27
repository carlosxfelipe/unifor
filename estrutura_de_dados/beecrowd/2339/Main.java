import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numCompetidores = scanner.nextInt();
    int folhasCompradas = scanner.nextInt();
    int folhasPorCompetidor = scanner.nextInt();

    int folhasNecessarias = numCompetidores * folhasPorCompetidor;

    if (folhasCompradas >= folhasNecessarias) {
      System.out.println("S");
    } else {
      System.out.println("N");
    }

    scanner.close();
  }
}
