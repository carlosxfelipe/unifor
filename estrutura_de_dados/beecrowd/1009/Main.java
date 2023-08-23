import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);

    String nomeVendedor = scanner.nextLine();
    double salarioFixo = scanner.nextDouble();
    double totalVendas = scanner.nextDouble();

    double comissao = totalVendas * 0.15;
    double totalReceber = salarioFixo + comissao;

    System.out.printf("TOTAL = R$ %.2f%n", totalReceber);

    scanner.close();
  }
}
