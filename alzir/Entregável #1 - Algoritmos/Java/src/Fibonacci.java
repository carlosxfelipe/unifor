import java.util.Scanner;

public class Fibonacci {

  public static int fibonacci(int num) {
    if (num < 2) {
      return num;
    } else {
      return fibonacci(num - 1) + fibonacci(num - 2);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um número: ");
    int n = sc.nextInt();
    if (n <= 0) {
      System.out.println("Digite um número inteiro positivo!");
    } else {
      for (int i = 0; i < n; i++) {
        System.out.println(fibonacci(i));
      }
    }
    sc.close();
  }
}
