import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Set<String> nomesPomekon = new LinkedHashSet<>();
    int contaPomekon = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < contaPomekon; i++) nomesPomekon.add(scanner.nextLine());

    System.out.println(
      "Falta(m) " + (151 - nomesPomekon.size()) + " pomekon(s)."
    );

    scanner.close();
  }
}
