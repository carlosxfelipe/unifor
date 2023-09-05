import ListaDinamica.ListaEncadeadaSimples;

public class Main {

  public static void main(String[] args) {
    ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

    lista.inserirInicio(1);
    lista.inserirFim(2);
    lista.inserirFim(3);
    lista.inserirPosicao(1, 4);
    lista.removerInicio();
    lista.removerFim();
    lista.removerPosicao(1);

    // System.out.println("Elemento na posição 2: " + lista.retornaValor(2));

    lista.exibirLista();
  }
}
