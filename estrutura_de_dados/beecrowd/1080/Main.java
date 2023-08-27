import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int maiorValor = Integer.MIN_VALUE;
    int posicao = -1;

    for (int i = 0; i < 100; i++) {
      int valor = scanner.nextInt();
      if (valor > maiorValor) {
        maiorValor = valor;
        posicao = i + 1; // Adiciona 1 para obter a posição real (começando em 1)
      }
    }

    scanner.close();

    System.out.println(maiorValor);
    System.out.println(posicao);
  }
}
