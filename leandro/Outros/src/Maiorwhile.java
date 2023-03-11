import java.util.Scanner;

public class Maiorwhile {

  public static void main(String[] args) {
    float maior, num;
    int contador = 2;
    Scanner sc = new Scanner(System.in);

    System.out.print("1º número: ");
    num = sc.nextFloat();
    maior = num;

    while (contador < 4) {
      System.out.print(contador + "º número: ");
      num = sc.nextFloat();

      if (num > maior) {
        maior = num;
      }

      contador++;
    }

    System.out.println("O maior número é : " + maior);
  }
}
