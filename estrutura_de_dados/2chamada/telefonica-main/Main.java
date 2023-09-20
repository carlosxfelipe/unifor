import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {

  static class SString implements Comparable<SString> {

    String valor;

    SString(String valor) {
      this.valor = valor;
    }

    @Override
    public int compareTo(SString outra) {
      return this.valor.compareTo(outra.valor);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextInt()) {
      int tamanho = scanner.nextInt();
      scanner.nextLine(); // nova linha

      List<SString> listaSStrings = new LinkedList<>();

      for (int i = 0; i < tamanho; i++) {
        listaSStrings.add(new SString(scanner.nextLine()));
      }

      listaSStrings.sort(null);

      int resposta = 0;

      for (int i = 1; i < tamanho; i++) {
        String s1 = listaSStrings.get(i).valor;
        String s2 = listaSStrings.get(i - 1).valor;
        int tamanhoMinimo = Math.min(s1.length(), s2.length());

        for (int j = 0; j < tamanhoMinimo; j++) {
          if (s1.charAt(j) == s2.charAt(j)) {
            resposta++;
          } else {
            break;
          }
        }
      }

      System.out.println(resposta);
    }

    scanner.close();
  }
}
