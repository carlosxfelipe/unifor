import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);

    double x = scanner.nextDouble();
    double y = scanner.nextDouble();

    String position = "";

    if (x == 0 && y == 0) {
      position = "Origem";
    } else if (x == 0) {
      position = "Eixo Y";
    } else if (y == 0) {
      position = "Eixo X";
    } else if (y > 0 && x > 0) {
      position = "Q1";
    } else if (y > 0 && x < 0) {
      position = "Q2";
    } else if (y < 0 && x < 0) {
      position = "Q3";
    } else if (y < 0 && x > 0) {
      position = "Q4";
    }

    System.out.println(position);

    scanner.close();
  }
}
