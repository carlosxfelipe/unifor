import ListaDinamica.ListaDuplamenteEncadeada;

public class App {

  public static void main(String[] args) throws Exception {
    ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>(
      100
    );

    lista.inserirInicio(0);
    lista.inserirInicio(1);
    lista.inserirInicio(2);
    lista.inserirFim(3);
    lista.inserirPosicao(0, 9999);
    lista.exibirLista(); // [9999, 2, 1, 0, 100, 3]

    System.out.println("\n" + "valor: " + lista.retornarValor(2)); // valor: 1
    lista.removerInicio(); // remove 9999
    lista.removerFim(); // remove 3
    lista.removerPosicao(0); // remove 2
    lista.exibirLista(); // [1, 0, 100]

    System.out.println("\nLista após a inversão:");
    lista.inverterLista();
    lista.exibirLista(); // [100, 0, 1]
  }
}
