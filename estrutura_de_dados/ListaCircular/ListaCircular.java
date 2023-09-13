public class ListaCircular<T> {

  private No<T> inicio;
  private No<T> fim;
  public int tamanho;

  public ListaCircular() {
    tamanho = 0;
    inicio = null;
    fim = null;
  }

  public ListaCircular(T valor) {
    No<T> novoNo = new No<T>(valor);
    inicio = novoNo;
    fim = novoNo;
    tamanho = 1;
    // Tornar a lista circular
    inicio.proximo = inicio;
    fim.proximo = inicio;
  }

  public void exibirLista() {
    System.out.print("[");
    No<T> noAux = inicio;
    do {
      System.out.print(noAux.valor);
      noAux = noAux.proximo;
      if (noAux != inicio) {
        System.out.print(", ");
      }
    } while (noAux != inicio);
    System.out.print("]");
  }

  public T retornarValor(int posicao) {
    return retornarNo(posicao).valor;
  }

  private No<T> retornarNo(int posicao) {
    if (posicao < 0 || posicao >= tamanho) {
      throw new IndexOutOfBoundsException(
        "Posição " + posicao + " está fora dos limites!"
      );
    }

    No<T> noAux = inicio;
    for (int i = 0; i < posicao; i++) {
      noAux = noAux.proximo;
    }

    return noAux;
  }

  public void inserirInicio(T valor) {
    No<T> novoNo = new No<>(valor);

    if (inicio == null) {
      inicio = novoNo;
      fim = novoNo;
      // Tornar a lista circular
      inicio.proximo = inicio;
      fim.proximo = inicio;
    } else {
      novoNo.proximo = inicio;
      inicio = novoNo;
      fim.proximo = inicio; // Atualizar o próximo do último nó
    }

    tamanho++;
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<>(valor);

    if (inicio == null) {
      inicio = novoNo;
      fim = novoNo;
      // Tornar a lista circular
      inicio.proximo = inicio;
      fim.proximo = inicio;
    } else {
      fim.proximo = novoNo;
      novoNo.proximo = inicio; // Atualizar o próximo do novo nó para apontar para o início
      fim = novoNo;
    }

    tamanho++;
  }

  public void inserirPosicao(int posicao, T valor) {
    if (posicao <= 0) {
      inserirInicio(valor);
    } else if (posicao >= tamanho) {
      inserirFim(valor);
    } else {
      No<T> novoNo = new No<>(valor);
      No<T> noAux = retornarNo(posicao - 1);
      novoNo.proximo = noAux.proximo;
      noAux.proximo = novoNo;
      tamanho++;
    }
  }

  public void removerInicio() {
    if (inicio == null) throw new RuntimeException("Lista vazia!");

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      inicio = inicio.proximo;
      fim.proximo = inicio; // Atualizar o próximo do último nó
    }
    tamanho--;
  }

  public void removerFim() {
    if (inicio == null) throw new RuntimeException("Lista vazia!");

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      No<T> noAux = retornarNo(tamanho - 2); // Obter o penúltimo nó
      noAux.proximo = inicio; // Atualizar o próximo do penúltimo nó
      fim = noAux; // Atualizar o fim para ser o penúltimo nó
    }
    tamanho--;
  }

  public void removerPosicao(int posicao) {
    if (posicao <= 0) {
      removerInicio();
    } else if (posicao >= tamanho - 1) {
      removerFim();
    } else {
      No<T> noAux = retornarNo(posicao - 1);
      noAux.proximo = noAux.proximo.proximo;
      tamanho--;
    }
  }

  public void inverterLista() {
    if (tamanho <= 1) {
      return;
    }

    No<T> noAtual = inicio;
    No<T> temp = null;

    do {
      temp = noAtual.proximo;
      noAtual.proximo = noAtual.anterior;
      noAtual.anterior = temp;
      noAtual = noAtual.anterior;
    } while (noAtual != inicio);

    temp = inicio;
    inicio = fim;
    fim = temp;
  }

  public boolean isCircular() {
    No<T> noAux = this.inicio;
    do {
      noAux = noAux.proximo;
    } while (noAux != this.inicio && noAux != null);

    return noAux == this.inicio;
  }

  private static class No<T> {

    T valor;
    No<T> proximo;
    No<T> anterior;

    public No(T valor) {
      this.valor = valor;
      this.proximo = null;
      this.anterior = null;
    }
  }
}
