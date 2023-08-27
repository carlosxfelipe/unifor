import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int x = scanner.nextInt();
    int y = scanner.nextInt();

    // Verifica se as coordenadas estão dentro da semi-quadra
    boolean dentro = x >= 0 && x <= 432 && y >= 0 && y <= 468;

    if (dentro) {
      System.out.println("dentro");
    } else {
      System.out.println("fora");
    }

    scanner.close();
  }
}
