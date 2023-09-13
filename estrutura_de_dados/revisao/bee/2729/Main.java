import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      String[] itens = scanner.nextLine().split(" ");
      Set<String> itensNaoRepetidos = new HashSet<>(Arrays.asList(itens));

      List<String> itensOrdenados = new ArrayList<>(itensNaoRepetidos);
      Collections.sort(itensOrdenados);

      System.out.println(String.join(" ", itensOrdenados));
    }

    scanner.close();
  }
}
