public class Contato {

  int id;
  String nome;
  String telefone;
  String nascimento;

  public void apresentar() {
    System.out.println("Id: " + id);
    System.out.println("Nome: " + nome);
    System.out.println("Telefone: " + telefone);
    System.out.println("Nascimento: " + nascimento);
  }
}
