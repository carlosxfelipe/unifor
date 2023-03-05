import java.util.Locale;
import java.util.Scanner;

public class Media {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    float nota1, nota2, nota3, media;

    System.out.println("Digite a primeira nota: ");
    nota1 = sc.nextFloat();

    System.out.println("Digite a segunda nota: ");
    nota2 = sc.nextFloat();

    System.out.println("Digite a terceira nota: ");
    nota3 = sc.nextFloat();

    media = (nota1 + nota2 + nota3) / 3;
    System.out.println(
      "A média calculada foi: " + String.format("%.2f", media)
    );
  }
}
