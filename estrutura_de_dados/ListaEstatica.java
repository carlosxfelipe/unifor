public class ListaEstatica<T> implements Lista<T> {

  private T[] lista;
  private int quantidadeElementos;

  @SuppressWarnings("unchecked")
  public ListaEstatica(int tamanho) {
    lista = (T[]) new Object[tamanho];
    quantidadeElementos = 0;
  }

  public boolean estaCheia() {
    return quantidadeElementos == lista.length;
  }

  public boolean estaVazia() {
    return quantidadeElementos == 0;
  }

  public void exibirLista() {
    if (estaVazia()) {
      throw new ListaVaziaException("A lista está vazia!");
    }
    System.out.print("[");
    for (int i = 0; i < quantidadeElementos; i++) {
      if (i != quantidadeElementos - 1) {
        System.out.print(lista[i] + ", ");
      } else {
        System.out.println(lista[i] + "]");
      }
    }
  }

  public void inserirFinal(T valor) throws ListaCheiaException {
    if (estaCheia()) {
      throw new ListaCheiaException("A lista está cheia!");
    }

    lista[quantidadeElementos] = valor;
    quantidadeElementos++;
  }

  public void inserirInicio(T valor) throws ListaCheiaException {
    if (estaCheia()) {
      throw new ListaCheiaException("A lista está cheia!");
    }

    for (int i = quantidadeElementos; i > 0; i--) {
      lista[i] = lista[i - 1];
    }
    lista[0] = valor;
    quantidadeElementos++;
  }

  public void inserirPosicao(int posicao, T valor) throws ListaCheiaException {
    if (estaCheia()) {
      throw new ListaCheiaException("A lista está cheia!");
    }

    if (posicao <= 0) {
      inserirInicio(valor);
    } else if (posicao >= quantidadeElementos) {
      inserirFinal(valor);
    } else {
      for (int i = quantidadeElementos; i > posicao; i--) {
        lista[i] = lista[i - 1];
      }
      lista[posicao] = valor;
      quantidadeElementos++;
    }
  }

  public int tamanho() {
    return quantidadeElementos;
  }

  public static void main(String[] args) {
    ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(10);
    listaEstatica.inserirFinal(2);
    listaEstatica.exibirLista();
    listaEstatica.inserirFinal(5);
    listaEstatica.exibirLista();
    listaEstatica.inserirInicio(7);
    listaEstatica.exibirLista();
    listaEstatica.inserirPosicao(1, 10);
    listaEstatica.exibirLista();
  }
}

interface Lista<T> {
  int tamanho();
  boolean estaVazia();
  boolean estaCheia();
  void inserirInicio(T valor) throws ListaCheiaException;
  void inserirFinal(T valor) throws ListaCheiaException;
  void inserirPosicao(int posicao, T valor) throws ListaCheiaException;
  void exibirLista();
}

class ListaVaziaException extends RuntimeException {

  public ListaVaziaException(String mensagem) {
    super(mensagem);
  }
}

class ListaCheiaException extends RuntimeException {

  public ListaCheiaException(String mensagem) {
    super(mensagem);
  }
}
