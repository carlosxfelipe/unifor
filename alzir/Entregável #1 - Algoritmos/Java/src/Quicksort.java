import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> numeros = new ArrayList<>();

    System.out.print("Digite a quantidade de números: ");
    int quantidade = sc.nextInt();

    perguntar(numeros, quantidade, sc);
  }

  public static void perguntar(
    List<Integer> numeros,
    int quantidade,
    Scanner sc
  ) {
    System.out.print(
      "Digite o número (" + (numeros.size() + 1) + " de " + quantidade + "): "
    );
    int numero = sc.nextInt();

    numeros.add(numero);

    if (quantidade <= numeros.size()) {
      sc.close();
      /* System.out.println(numeros.stream().sorted().toList()); */
      System.out.println(quicksort(numeros));
    } else {
      perguntar(numeros, quantidade, sc);
    }
  }

  public static List<Integer> quicksort(List<Integer> arr) {
    if (arr.size() <= 1) {
      return arr;
    }

    int pivo = arr.get(0);
    List<Integer> esquerda = new ArrayList<>();
    List<Integer> direita = new ArrayList<>();

    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i) < pivo) {
        esquerda.add(arr.get(i));
      } else {
        direita.add(arr.get(i));
      }
    }

    List<Integer> resultado = new ArrayList<>();
    resultado.addAll(quicksort(esquerda));
    resultado.add(pivo);
    resultado.addAll(quicksort(direita));

    return resultado;
  }
}
