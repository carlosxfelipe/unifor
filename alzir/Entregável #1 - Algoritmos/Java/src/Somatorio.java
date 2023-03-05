import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Somatorio {

  static List<String> numeros = new ArrayList<String>();

  static void obterSoma(List<String> numeros) {
    int soma = 0;
    for (int i = numeros.size() - 1; i >= 0; i--) {
      soma += Integer.parseInt(numeros.get(i));
    }
    System.out.println("O somatório é " + soma);
  }

  static void obterNumero(int quantidade) {
    Scanner sc = new Scanner(System.in);
    System.out.print(
      "Digite o número (" + (numeros.size() + 1) + " de " + quantidade + "): "
    );
    String numero = sc.nextLine();
    numeros.add(numero);

    if (quantidade <= numeros.size()) {
      sc.close();
      obterSoma(numeros);
    } else {
      obterNumero(quantidade);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite a quantidade de números: ");
    String quantidadeStr = sc.nextLine();

    try {
      int quantidade = Integer.parseInt(quantidadeStr);
      obterNumero(quantidade);
    } catch (NumberFormatException e) {
      System.out.println("Digite um número inteiro positivo!");
      sc.close();
    }
  }
}
