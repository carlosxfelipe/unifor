import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);

    double N1 = scanner.nextDouble();
    double N2 = scanner.nextDouble();
    double N3 = scanner.nextDouble();
    double N4 = scanner.nextDouble();

    double media = (N1 * 2 + N2 * 3 + N3 * 4 + N4 * 1) / 10;

    double truncatedMedia = Math.floor(media * 10) / 10;

    System.out.printf("Media: %.1f%n", truncatedMedia);

    if (truncatedMedia >= 7.0) {
      System.out.println("Aluno aprovado.");
    } else if (truncatedMedia < 5.0) {
      System.out.println("Aluno reprovado.");
    } else {
      System.out.println("Aluno em exame.");
      double exame = scanner.nextDouble();
      System.out.printf("Nota do exame: %.1f%n", exame);
      double novaMedia = (truncatedMedia + exame) / 2;
      if (novaMedia >= 5.0) {
        System.out.println("Aluno aprovado.");
      } else {
        System.out.println("Aluno reprovado.");
      }
      System.out.printf("Media final: %.1f%n", novaMedia);
    }

    scanner.close();
  }
}
