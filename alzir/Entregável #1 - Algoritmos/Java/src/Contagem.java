import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contagem {

  static List<String> numeros = new ArrayList<>();

  public static List<String> filtrar(List<String> numeros) {
    List<String> inteiros = new ArrayList<>();
    for (String item : numeros) {
      int numero = Integer.parseInt(item);
      if (numero > 0) {
        inteiros.add(item);
      }
    }
    System.out.println(inteiros.size() + " " + inteiros);
    return inteiros;
  }

  public static void perguntar(int quantidade) {
    Scanner sc = new Scanner(System.in);
    System.out.print(
      "Digite o número (" + (numeros.size() + 1) + " de " + quantidade + "): "
    );
    String numero = sc.nextLine();
    numeros.add(numero);

    if (quantidade <= numeros.size()) {
      sc.close();
      filtrar(numeros);
    } else {
      perguntar(quantidade);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite a quantidade de números: ");
    String quantidadeString = sc.nextLine();
    try {
      int quantidade = Integer.parseInt(quantidadeString);
      perguntar(quantidade);
    } catch (NumberFormatException e) {
      System.out.println("Você não digitou um número!");
    }
    sc.close();
  }
}
