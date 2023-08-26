import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      int numberOfRounds = scanner.nextInt();
      if (numberOfRounds == 0) {
        break;
      }

      int pointsA = 0;
      int pointsB = 0;

      for (int i = 0; i < numberOfRounds; i++) {
        int chosenNumberPlayerA = scanner.nextInt();
        int chosenNumberPlayerB = scanner.nextInt();

        if (chosenNumberPlayerA > chosenNumberPlayerB) {
          pointsA++;
        } else if (chosenNumberPlayerB > chosenNumberPlayerA) {
          pointsB++;
        }
      }

      System.out.println(pointsA + " " + pointsB);
    }
    scanner.close();
  }
}
