public class ListaEncadeadaSimples<T> {

  private No<T> inicio;

  public ListaEncadeadaSimples() {
    this.inicio = null;
  }

  public ListaEncadeadaSimples(T valor) {
    this.inicio = new No<>(valor);
  }

  // Retorna o valor de um nó na posição especificada
  public T retornaValor(int posicao) {
    if (posicao < 0 || inicio == null) {
      throw new IndexOutOfBoundsException("Posição inválida ou lista vazia");
    }

    No<T> atual = inicio;
    int contador = 0;

    while (contador < posicao) {
      if (atual.proximo == null) {
        throw new IndexOutOfBoundsException("Posição inválida");
      }
      atual = atual.proximo;
      contador++;
    }

    return atual.valor;
  }

  public void inserirInicio(T valor) {
    No<T> novoNo = new No<>(valor);
    novoNo.proximo = inicio;
    inicio = novoNo;
  }

  public void removerInicio() {
    if (inicio != null) {
      inicio = inicio.proximo;
    }
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<>(valor);

    if (inicio == null) {
      inicio = novoNo;
      return;
    }

    No<T> atual = inicio;
    while (atual.proximo != null) {
      atual = atual.proximo;
    }

    atual.proximo = novoNo;
  }

  public void removerFim() {
    if (inicio == null) {
      return;
    }

    if (inicio.proximo == null) {
      inicio = null;
      return;
    }

    No<T> atual = inicio;
    while (atual.proximo.proximo != null) {
      atual = atual.proximo;
    }

    atual.proximo = null;
  }

  public void inserirPosicao(int posicao, T valor) {
    if (posicao < 0) {
      throw new IndexOutOfBoundsException("Posição inválida");
    }

    if (posicao == 0) {
      inserirInicio(valor);
      return;
    }

    No<T> novoNo = new No<>(valor);
    No<T> atual = inicio;
    int contador = 0;

    while (contador < posicao - 1) {
      if (atual == null) {
        throw new IndexOutOfBoundsException("Posição inválida");
      }
      atual = atual.proximo;
      contador++;
    }

    if (atual != null) {
      novoNo.proximo = atual.proximo;
      atual.proximo = novoNo;
    }
  }

  public void removerPosicao(int posicao) {
    if (posicao < 0 || inicio == null) {
      throw new IndexOutOfBoundsException("Posição inválida ou lista vazia");
    }

    if (posicao == 0) {
      removerInicio();
      return;
    }

    No<T> atual = inicio;
    int contador = 0;

    while (contador < posicao - 1) {
      if (atual.proximo == null) {
        throw new IndexOutOfBoundsException("Posição inválida");
      }
      atual = atual.proximo;
      contador++;
    }

    if (atual.proximo != null) {
      atual.proximo = atual.proximo.proximo;
    }
  }

  public void inverterLista() {
    if (inicio == null || inicio.proximo == null) {
      return;
    }

    No<T> anterior = null;
    No<T> atual = inicio;
    No<T> proximo = null;

    while (atual != null) {
      proximo = atual.proximo;
      atual.proximo = anterior;
      anterior = atual;
      atual = proximo;
    }

    inicio = anterior; // O último elemento (anterior) se torna o novo início da lista.
  }

  public void exibirLista() {
    No<T> atual = inicio;

    while (atual != null) {
      System.out.print(atual.valor + " -> ");
      atual = atual.proximo;
    }
    System.out.println("null");
  }

  private static class No<T> {

    T valor;
    No<T> proximo;

    No(T valor) {
      this.valor = valor;
      this.proximo = null;
    }
  }
}
