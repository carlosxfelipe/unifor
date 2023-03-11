public class Cachorro {

  private String nome;
  String raca;
  String cor;
  int idade;
  String porte;
  float peso;
  float altura;
  String sexo;
  private String proprietario;

  // get - lê o valor do atributo
  public String getProprietario() {
    return proprietario;
  }

  public String getNome() {
    return nome;
  }

  // set - modifica o valor do atributo
  public void setProprietario(String proprietario) {
    this.proprietario = proprietario;
  }

  public void setNome(String cachorro) {
    this.nome = cachorro;
  }

  public void mostrarDetalhes() {
    System.out.println("DADOS DO ANIMAL");
    System.out.println("Nome: " + nome);
    System.out.println("Altura: " + altura);
    System.out.println("Peso: " + peso);
    System.out.println("Proprietário: " + proprietario);
  }

  public Cachorro(String cachorro, String proprietario) {
    this.setNome(cachorro);
    this.setProprietario(proprietario);
  }
}
