import java.util.Scanner;

public class Positivo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num;

    System.out.print("Digite um número: ");
    num = sc.nextInt();

    if (num == 0) {
      System.out.println("0 não é positivo e nem negativo");
    } else {
      if (num > 0) {
        System.out.println(num + " é positivo!");
      } else {
        System.out.println(num + " é negativo");
      }
    }
  }
}
