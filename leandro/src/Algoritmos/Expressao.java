import java.util.Locale;
import java.util.Scanner;

public class Expressao {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    double a, b, c, d, calculo;

    System.out.print("Digite o primeiro número: ");
    a = sc.nextDouble();

    System.out.print("Digite o segundo número: ");
    b = sc.nextDouble();

    System.out.print("Digite o terceiro número: ");
    c = sc.nextDouble();

    System.out.print("Digite o quarto número: ");
    d = sc.nextDouble();

    calculo = (a + b) * (c - d);
    System.out.println("Resultado: " + String.format("%.2f", calculo));
  }
}
