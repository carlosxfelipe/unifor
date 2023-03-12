import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    ArrayList<Aluno> alunos = new ArrayList<>();
    alunos.add(new Aluno("Carlos Felipe", 12345));
    alunos.add(new Aluno("Caio Souza", 23456));

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Deseja adicionar um novo aluno? (s/n)");
      String resposta = sc.nextLine().toLowerCase();

      if (resposta.equals("s")) {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = sc.nextInt();
        sc.nextLine(); // quebra de linha
        alunos.add(new Aluno(nome, matricula));
      } else {
        break;
      }
    }

    for (Aluno aluno : alunos) {
      aluno.apresentar();
    }
    Perguntas.main(args);
    sc.close();
  }
}
