import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String cpf = scanner.nextLine();

      String[] parts = cpf.split("[.-]");
      // System.out.println(parts.length);

      for (int i = 0; i < parts.length; i++) {
        System.out.println(parts[i]);
      }
    }

    scanner.close();
  }
}
