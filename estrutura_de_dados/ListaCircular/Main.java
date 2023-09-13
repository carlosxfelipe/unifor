public class Main {

  public static void main(String[] args) {
    ListaCircular<Integer> lista = new ListaCircular<>();
    lista.inserirInicio(3);
    lista.inserirInicio(2);
    lista.inserirInicio(1);

    System.out.println("Lista após inserção no início:");
    lista.exibirLista();

    lista.inserirFim(4);
    lista.inserirFim(5);

    System.out.println("\nLista após inserção no final:");
    lista.exibirLista();

    lista.removerInicio();
    lista.removerFim();

    System.out.println("\nLista após remoção do início e do final:");
    lista.exibirLista();

    System.out.println("\nA lista é circular: " + lista.isCircular());
  }
}
