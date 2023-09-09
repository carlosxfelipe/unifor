import ListaDinamica.ListaEncadeadaSimples;

public class Main {

  public static void main(String[] args) {
    ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

    lista.inserirInicio(1);
    lista.inserirFim(2);
    lista.inserirFim(3);
    lista.inserirPosicao(1, 2);

    System.out.println("Lista após as inserções:");
    lista.exibirLista();

    lista.removerInicio();
    lista.removerFim();
    lista.removerPosicao(1);

    System.out.println("\nLista após as remoções:");
    lista.exibirLista();
  }
}
