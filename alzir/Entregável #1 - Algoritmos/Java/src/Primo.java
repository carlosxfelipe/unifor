import java.util.Scanner;

public class Primo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um número n: ");
    int num = sc.nextInt();
    int divisores = 0;

    for (int cont = 1; cont <= num; cont++) {
      if (num % cont == 0) {
        divisores++;
      }
    }

    if (divisores == 2) {
      System.out.println(num + " é número primo!");
    } else {
      System.out.println(num + " não é número primo!");
    }
    sc.close();
  }
}
