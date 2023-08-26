import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    int count = 1;

    for (int i = 0; i < N; i++) {
      System.out.println(
        count + " " + (count + 1) + " " + (count + 2) + " PUM"
      );
      count += 4;
    }

    scanner.close();
  }
}
