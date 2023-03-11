import java.util.Scanner;

public class Data {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String meses[] = {
      "janeiro",
      "fevereiro",
      "março",
      "abril",
      "maio",
      "junho",
      "julho",
      "agosto",
      "setembro",
      "outubro",
      "novembro",
      "dezembro",
    };
    String data[];
    String dia, mes, ano;

    System.out.println("Digite uma data");
    System.out.print("DD/MM/AAAA: ");

    data = sc.next().split("/");

    dia = data[0];
    mes = data[1];
    ano = data[2];

    System.out.println(
      dia + " de " + meses[Integer.parseInt(mes) - 1] + " de " + ano
    );
  }
}
