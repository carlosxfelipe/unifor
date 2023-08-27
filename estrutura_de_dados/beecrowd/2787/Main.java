import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    short linha, coluna;

    linha = scanner.nextShort();
    coluna = scanner.nextShort();

    if (
      (linha % 2 == 0 && coluna % 2 == 0) || (linha % 2 == 1 && coluna % 2 == 1)
    ) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }

    scanner.close();
  }
}
