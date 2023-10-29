import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  ArrayList<Integer> arrayList = new ArrayList<>();

  // LinkedList<Integer> linkedList = new LinkedList<>();
  // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
  // HashMap<Integer, String> hashTable = new HashMap<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    // for (int i = 0; i < N; i++) {
    //   System.out.println(N);
    // }

    // Ler todos os valores em uma única linha
    for (int i = 0; i < N; i++) {
      int value = scanner.nextInt();
      System.out.print(value + " ");
    }

    scanner.close();
  }
}
