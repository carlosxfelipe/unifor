import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    for (int k = 0; k < N; k++) {
      int valor = 0;
      int L = scanner.nextInt();

      for (int i = 0; i < L; i++) {
        String frase = scanner.next();

        for (int j = 0; j < frase.length(); j++) {
          valor += (frase.charAt(j) - 'A' + i + j);
        }
      }

      System.out.println(valor);
    }

    scanner.close();
  }
}
