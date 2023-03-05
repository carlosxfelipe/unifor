import java.util.LinkedList;
import java.util.Scanner;

public class Pares {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int cont = 0;
    int num;
    LinkedList<Integer> pares = new LinkedList<>();

    while (cont < 10) {
      System.out.print("Digite um número par: ");

      if (sc.hasNextInt()) {
        num = sc.nextInt();

        if (num % 2 == 0) {
          pares.push(num);
          System.out.println(pares);
          cont++;
        }
      } else {
        sc.next();
      }
    }
  }
}
