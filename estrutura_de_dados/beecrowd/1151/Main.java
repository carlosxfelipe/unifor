import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // int n = 5;

    int a = 0, b = 1, c = 0;

    if (n == 0 || n == 1) {
      scanner.close();
      return;
    }

    System.out.print(a + " ");
    for (int i = 2; i < n; i++) {
      a = b;
      b = c;
      c = a + b;
      System.out.print(c + " ");
    }

    System.out.println(c + b);
    scanner.close();
  }
}
