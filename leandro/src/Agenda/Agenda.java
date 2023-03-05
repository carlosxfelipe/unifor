import java.util.Scanner;

public class Agenda {

  Scanner sc = new Scanner(System.in);

  Contato[] lista = new Contato[10];
  int posicao = -1;

  public void inserir() {
    Contato pessoa = new Contato();

    System.out.println("Digite o id do contato: ");
    pessoa.id = Integer.parseInt(sc.nextLine());

    System.out.println("Digite o nome do contato: ");
    pessoa.nome = sc.nextLine();

    System.out.println("Digite o telefone do contato: ");
    pessoa.telefone = sc.nextLine();

    System.out.println("Digite o nascimento do contato: ");
    pessoa.nascimento = sc.nextLine();

    posicao++;
    lista[posicao] = pessoa;
  }

  public void alterar(int localizacao) {
    if (localizacao > posicao) {
      System.out.println("Contato inexiste");
    } else {
      Contato pessoa = lista[localizacao];
      System.out.println("Você selecionou o contato: ");
      pessoa.apresentar();
      System.out.println("Digite o novo telefone do contato: ");
      pessoa.telefone = sc.nextLine();
      pessoa.apresentar();
    }
  }

  public void excluir() {}

  public void consultar() {}
  
}
