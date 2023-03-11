import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Somatorio {

  static List<String> numeros = new ArrayList<String>();

  static void somar(List<String> numeros) {
    int soma = 0;
    for (int i = numeros.size() - 1; i >= 0; i--) {
      soma += Integer.parseInt(numeros.get(i));
    }
    System.out.println("O somatório é " + soma);
  }

  static void perguntar(int quantidade) {
    Scanner sc = new Scanner(System.in);
    System.out.print(
      "Digite o número (" + (numeros.size() + 1) + " de " + quantidade + "): "
    );
    String numero = sc.nextLine();
    numeros.add(numero);

    if (quantidade <= numeros.size()) {
      sc.close();
      somar(numeros);
    } else {
      perguntar(quantidade);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite a quantidade de números: ");
    String quantidadeStr = sc.nextLine();

    try {
      int quantidade = Integer.parseInt(quantidadeStr);
      perguntar(quantidade);
    } catch (NumberFormatException e) {
      System.out.println("Digite um número inteiro positivo!");
      sc.close();
    }
  }
}
