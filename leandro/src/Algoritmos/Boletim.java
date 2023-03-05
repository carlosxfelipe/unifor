import java.util.Locale;
import java.util.Scanner;

public class Boletim {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    double n1, n2, n3, n4, media;

    System.out.print("Digite a primeira nota: ");
    n1 = sc.nextDouble();

    System.out.print("Digite a segunda nota: ");
    n2 = sc.nextDouble();

    System.out.print("Digite a terceira nota: ");
    n3 = sc.nextDouble();

    System.out.print("Digite a quarta nota: ");
    n4 = sc.nextDouble();

    media = (n1 + n2 + n3 + n4) / 4;
    System.out.println("Média: " + media);

    if (media >= 8) {
      System.out.println("situação: aprovado");
    }
    if (media >= 4) {
      System.out.println("situação: final");
    }
    if (media < 4) {
      System.out.println("situação: reprovado");
    }
  }
}
