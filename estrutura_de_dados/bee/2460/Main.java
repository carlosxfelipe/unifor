import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    ArrayList<Integer> fila = new ArrayList<>();
    Set<Integer> idsToRemove = new HashSet<>();

    for (int i = 0; i < N; i++) {
      int id = scanner.nextInt();
      fila.add(id);
    }

    int M = scanner.nextInt();

    for (int i = 0; i < M; i++) {
      int id = scanner.nextInt();
      idsToRemove.add(id);
    }

    scanner.close();

    ArrayList<Integer> novaFila = new ArrayList<>();
    for (int id : fila) {
      if (!idsToRemove.contains(id)) {
        novaFila.add(id);
      }
    }

    for (int id : novaFila) {
      System.out.print(id + " ");
    }
  }
}
