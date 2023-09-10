import ListaDinamica.ListaEncadeadaSimples;

public class Main {

  public static void main(String[] args) {
    ListaEncadeadaSimples<Object> lista = new ListaEncadeadaSimples<>(100);

    // lista.inserirInicio("a");
    // lista.inserirInicio("b");

    lista.inserirInicio(1);
    lista.inserirFim(2);
    lista.inserirFim(3);
    lista.inserirPosicao(1, "@");

    System.out.println("Lista após as inserções:");
    lista.exibirLista(); // [1, @, 100, 2, 3]

    lista.removerInicio();
    lista.removerFim();
    lista.removerPosicao(1);

    System.out.println("\nLista após as remoções:");
    lista.exibirLista(); // [@, 2]
  }
}
