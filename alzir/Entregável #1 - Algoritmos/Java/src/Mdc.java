import java.util.Scanner;

public class Mdc {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite dois números inteiros: ");
    String input = sc.nextLine();
    sc.close();
    mdc(input.replace(",", ""));
  }

  public static void mdc(String input) {
    String[] numeros = input.split(" ");

    if (!numeros[0].matches("[0-9]+") || !numeros[1].matches("[0-9]+")) {
      System.out.println("Os valores devem ser números positivos!");
      return;
    }

    int a = Integer.parseInt(numeros[0]);
    int b = Integer.parseInt(numeros[1]);

    if (a <= 0 || b <= 0) {
      System.out.println("Os números devem ser positivos!");
      return;
    }

    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    System.out.println(a);
  }
}
