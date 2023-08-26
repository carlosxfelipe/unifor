import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    for (int i = 0; i < number; i++) {
      int X = scanner.nextInt();
      int Y = scanner.nextInt();

      if (Y == 0) {
        System.out.println("divisao impossivel");
      } else {
        double division = (double) X / Y;
        System.out.println(String.format("%.1f", division));
      }
    }

    scanner.close();
  }
}
