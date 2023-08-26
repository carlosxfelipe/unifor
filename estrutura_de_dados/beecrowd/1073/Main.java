import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    for (int i = 2; i <= number; i += 2) {
      int square = i * i;
      System.out.println(i + "^2 = " + square);
    }

    scanner.close();
  }
}
