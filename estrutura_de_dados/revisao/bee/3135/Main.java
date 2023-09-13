import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n;
    do {
      n = scanner.nextInt();
    } while (n < 2);

    scanner.nextLine();

    List<String> nomes = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String nome = scanner.nextLine();
      nomes.add(nome);
    }

    Collections.sort(nomes, Comparator.comparing(String::length));

    for (int i = 0; i < nomes.size(); i++) {
      System.out.print(nomes.get(i));
      if (i < nomes.size() - 1) {
        System.out.print(", ");
      }
    }
    scanner.close();
  }
}
