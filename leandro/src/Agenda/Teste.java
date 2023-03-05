public class Teste {

  public static void main(String[] args) {
    Agenda a = new Agenda();
    a.inserir();
    a.inserir();
    a.inserir();

    a.alterar(2);

    for (int i = 0; i <= a.posicao; i++) { // a.lista.length
      a.lista[i].apresentar();
    }
  }
}
