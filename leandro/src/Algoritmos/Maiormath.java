import java.util.Locale;
import java.util.Scanner;

public class Maiormath {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    double n1, n2, n3, maior;

    System.out.print("Digite o primeiro número: ");
    n1 = sc.nextDouble();

    System.out.print("Digite o segundo número: ");
    n2 = sc.nextDouble();

    System.out.print("Digite o terceiro número: ");
    n3 = sc.nextDouble();

    maior = Math.max(Math.max(n1, n2), n3);

    System.out.println("O maior número é " + maior);
  }
}
