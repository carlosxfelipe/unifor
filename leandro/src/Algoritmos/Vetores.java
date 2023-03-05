import java.util.Scanner;

public class Vetores {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String alunos[] = new String[40];

    for (int i = 0; i < 5; i++) {
      System.out.println("Digite o nome do " + (i + 1) + "º aluno: ");
      alunos[i] = sc.nextLine();
    }

    for (int i = 0; i < alunos.length; i++) {
      System.out.print(alunos[i] + " , ");
    }
  }
}
