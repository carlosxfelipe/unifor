import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);

    float[][] M = new float[12][12];
    char[] O = new char[2];
    int i, j;
    float sum = 0;
    int count = 0;

    O = scanner.nextLine().toCharArray();
    for (i = 0; i < 12; i++) {
      for (j = 0; j < 12; j++) {
        M[i][j] = scanner.nextFloat();

        if (j < 11 - i) {
          sum += M[i][j];
          count += 1;
        }
      }
    }
    if (O[0] == 'S') {
      System.out.printf("%.1f\n", sum);
    } else {
      System.out.printf("%.1f\n", (sum / count));
    }
  }
}
