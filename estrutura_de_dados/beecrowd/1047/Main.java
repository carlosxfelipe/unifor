import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int horaInicio = scanner.nextInt();
    int minutoInicio = scanner.nextInt();
    int horaFim = scanner.nextInt();
    int minutoFim = scanner.nextInt();

    int minutosTotalInicio = (horaInicio * 60) + minutoInicio;
    int minutosTotalFim = (horaFim * 60) + minutoFim;
    int minutosPorDia = (24 * 60);
    int duracaoMinutos = 0;

    if (minutosTotalFim > minutosTotalInicio) {
      duracaoMinutos = minutosTotalFim - minutosTotalInicio;
      System.out.printf(
        "O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n",
        (duracaoMinutos / 60),
        (duracaoMinutos % 60)
      );
    } else if (minutosTotalInicio > minutosTotalFim) {
      duracaoMinutos = (minutosPorDia - minutosTotalInicio) + minutosTotalFim;
      System.out.printf(
        "O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n",
        (duracaoMinutos / 60),
        (duracaoMinutos % 60)
      );
    } else if (minutosTotalFim == minutosTotalInicio) {
      System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", 24, 0);
    }

    scanner.close();
  }
}
