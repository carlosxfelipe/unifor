import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    alunos.add(new Aluno("Carlos Felipe", 12345));
    alunos.add(new Aluno("Caio Souza", 23456));

    Scanner scanner = new Scanner(System.in);
    String resposta;

    do {
      System.out.println("Deseja adicionar um novo aluno? (s/n)");
      resposta = scanner.nextLine();

      if (resposta.equals("s")) {
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite a matrícula do aluno:");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // quebra de linha
        alunos.add(new Aluno(nome, matricula));
      }
    } while (resposta.equals("s"));
    scanner.close();
    for (Aluno aluno : alunos) {
      aluno.apresentar();
    }
  }
}
