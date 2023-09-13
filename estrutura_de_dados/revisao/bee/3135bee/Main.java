import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    List<List<String>> nomes = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      nomes.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      String nome = scanner.nextLine();
      int tamanho = nome.length();
      nomes.get(tamanho).add(nome);
    }

    nomes.removeIf(list -> list.isEmpty());

    while (!nomes.isEmpty()) {
      List<String> listaAtual = nomes.get(0);
      StringBuilder resultado = new StringBuilder();

      for (String nome : listaAtual) {
        resultado.append(nome.charAt(0)).append(", ");
      }

      System.out.print(resultado.substring(0, resultado.length() - 2)); // Remover a última vírgula e espaço
      System.out.println();

      nomes.remove(0);
      nomes.removeIf(list -> list.isEmpty());
    }
    scanner.close();
  }
}
