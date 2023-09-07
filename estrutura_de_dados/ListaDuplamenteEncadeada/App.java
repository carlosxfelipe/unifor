import ListaDinamica.ListaDuplamenteEncadeada;

public class App {

  public static void main(String[] args) throws Exception {
    ListaDuplamenteEncadeada<Object> minhaLDE = new ListaDuplamenteEncadeada<>(
      68
    );

    minhaLDE.inserirInicio(0);
    minhaLDE.inserirInicio(1);
    minhaLDE.inserirInicio(2);
    minhaLDE.inserirFim(5);

    System.out.println("valor: " + minhaLDE.retornarValor(2));
    minhaLDE.inserirPosicao(1, 9999);
    minhaLDE.removerInicio();
    minhaLDE.removerFim();
    minhaLDE.removerPosicao(0);
    minhaLDE.exibirLista();
  }
}
