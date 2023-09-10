public class Main {

  public static void main(String[] args) {
    ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

    lista.inserirInicio(1);
    lista.inserirFim(3);
    lista.inserirPosicao(1, 2);

    System.out.println("Lista após as inserções:");
    lista.exibirLista(); // Saída: 1 -> 2 -> 3 -> null

    lista.removerFim();
    lista.removerPosicao(1);

    System.out.println("\nLista após as remoções:");
    lista.exibirLista(); // Saída: 1 -> null

    System.out.println("Índice 0: " + lista.retornaValor(0));
  }
}
