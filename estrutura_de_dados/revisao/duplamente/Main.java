public class Main {

  public static void main(String[] args) {
    ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();

    lista.inserirInicio(1);
    lista.inserirFim(3);
    lista.inserirPosicao(1, 2);

    System.out.println("Lista após as inserções:");
    lista.exibirLista(); // Saída: 1 -> 2 -> 3 -> null

    System.out.println("\nLista após a inversão:");
    lista.inverterLista();
    lista.exibirLista(); // Saída: 3 -> 2 -> 1 -> null

    lista.removerFim();
    lista.removerPosicao(1);

    System.out.println("\nLista após as remoções:");
    lista.exibirLista(); // Saída: 3 -> null

    System.out.println("Índice 0: " + lista.retornaValor(0)); // Saída: Índice 0: 3
  }
}
