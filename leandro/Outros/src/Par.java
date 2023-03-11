import java.util.Scanner;

public class Par {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num;

    System.out.print("Digite um número: ");
    num = sc.nextInt();

    if (num % 2 == 0) {
      System.out.println(num + " é par!");
    } else {
      System.out.println(num + " é ímpar");
    }
  }
}
