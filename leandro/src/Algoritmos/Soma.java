import java.util.Locale;
import java.util.Scanner;

public class Soma {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n1, n2, n3, n4, n5, n6, soma;

    System.out.println("Digite o primeiro número: ");
    n1 = sc.nextInt();

    System.out.println("Digite o segundo número: ");
    n2 = sc.nextInt();

    System.out.println("Digite o terceiro número: ");
    n3 = sc.nextInt();

    System.out.println("Digite o quanrto número: ");
    n4 = sc.nextInt();

    System.out.println("Digite o quinto número: ");
    n5 = sc.nextInt();

    System.out.println("Digite o sexto número: ");
    n6 = sc.nextInt();

    soma = n1 + n2 + n3 + n4 + n5 + n6;
    System.out.println("A soma de todos os valores é " + soma);
  }
}
