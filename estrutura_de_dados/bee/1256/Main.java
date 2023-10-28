import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int index;

    for (int q = 0; q < N; q++) {
      int M = sc.nextInt();
      int C = sc.nextInt();
      int[] dados = new int[C];

      for (int i = 0; i < C; i++) dados[i] = sc.nextInt();

      LinkedList<String> keys = new LinkedList<>();

      for (int i = 0; i < M; i++) {
        keys.add("");
      }

      for (Integer x : dados) {
        index = x % keys.size();
        keys.set(index, keys.get(index) + " -> " + x);
      }

      for (int i = 0; i < M; i++) {
        System.out.println(i + keys.get(i) + " -> \\");
      }
      if (q < N - 1) System.out.println();
    }
    sc.close();
  }
}
