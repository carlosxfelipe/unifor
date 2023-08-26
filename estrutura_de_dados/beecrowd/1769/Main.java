import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        String input = scanner.nextLine().replaceAll("[-.]", "");
        int[] cpf = new int[11];

        for (int i = 0; i < 11; i++) {
          cpf[i] = Character.getNumericValue(input.charAt(i));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
          soma += (i + 1) * cpf[i];
        }

        soma %= 11;
        if (soma == 10) {
          soma = 0;
        }

        if (soma == cpf[9]) {
          soma = 0;
          for (int i = 0; i < 9; i++) {
            soma += (9 - i) * cpf[i];
          }

          soma %= 11;
          if (soma == 10) {
            soma = 0;
          }

          if (soma == cpf[10]) {
            System.out.println("CPF valido");
          } else {
            System.out.println("CPF invalido");
          }
        } else {
          System.out.println("CPF invalido");
        }
      } catch (Exception e) {
        break;
      }
    }
    scanner.close();
  }
}
