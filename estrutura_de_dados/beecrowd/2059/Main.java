import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int p, j1, j2, r, a, win, sum;
    p = scanner.nextInt();
    j1 = scanner.nextInt();
    j2 = scanner.nextInt();
    r = scanner.nextInt();
    a = scanner.nextInt();

    sum = j1 + j2;
    if ((sum % 2 == 0 && p == 1) || (sum % 2 == 1 && p == 0)) win =
      1; else win = 2;

    if ((r == 1 && a == 0) || (r == 0 && a == 1)) win = 1; else if (
      r == 1 && a == 1
    ) win = 2;

    System.out.println("Jogador " + win + " ganha!");

    scanner.close();
  }
}
