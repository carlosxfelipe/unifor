import ListaDinamica.ListaDuplamenteEncadeada;

public class App {

  public static void main(String[] args) throws Exception {
    ListaDuplamenteEncadeada<Object> lista = new ListaDuplamenteEncadeada<>(68);

    lista.inserirInicio(0);
    lista.inserirInicio(1);
    lista.inserirInicio(2);
    lista.inserirFim(5);

    System.out.println("valor: " + lista.retornarValor(2));
    lista.inserirPosicao(1, 9999);
    lista.removerInicio();
    lista.removerFim();
    lista.removerPosicao(0);
    lista.exibirLista();
  }
}
