package ListaDinamica;

public class ListaEncadeadaSimples<T> {

  private No<T> inicio;
  private No<T> fim;
  private int tamanho;

  public ListaEncadeadaSimples() {
    tamanho = 0;
    inicio = null;
    fim = null;
  }

  public ListaEncadeadaSimples(T valor) {
    No<T> novoNo = new No<T>(valor);
    inicio = novoNo;
    fim = novoNo;
    tamanho = 1;
  }

  public T retornaValor(int posicao) {
    return retornaNo(posicao).valor;
  }

  private No<T> retornaNo(int posicao) {
    if (inicio == null || posicao < 0 || posicao >= tamanho) {
      throw new RuntimeException(
        "Lista está vazia ou a posição está fora dos limites da lista!"
      );
    }

    No<T> noAuxiliar = inicio;
    for (int i = 0; i < posicao; i++) {
      noAuxiliar = noAuxiliar.proximo;
    }
    return noAuxiliar;
  }

  public void inserirInicio(T valor) {
    No<T> novoNo = new No<T>(valor);
    if (inicio == null) {
      inicio = novoNo;
      fim = novoNo;
    } else {
      novoNo.proximo = inicio;
      inicio = novoNo;
    }
    tamanho++;
  }

  public void removerInicio() {
    if (tamanho == 0) throw new RuntimeException(
      "A lista está vazia. Não é possível remover o início."
    );

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      No<T> noAuxiliar = inicio;
      inicio = noAuxiliar.proximo;
      noAuxiliar.proximo = null;
    }
    tamanho--;
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<T>(valor);
    if (inicio == null) {
      inicio = novoNo;
    } else {
      fim.proximo = novoNo;
    }
    fim = novoNo;
    tamanho++;
  }

  public void removerFim() {
    if (tamanho == 0) throw new RuntimeException(
      "A lista está vazia. Não é possível remover o fim."
    );

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      No<T> noAnterior = retornaNo(tamanho - 2);
      noAnterior.proximo = null;
      fim = noAnterior;
    }
    tamanho--;
  }

  public void inserirPosicao(int posicao, T valor) {
    if (posicao <= 0) {
      inserirInicio(valor);
    } else if (posicao >= tamanho) {
      inserirFim(valor);
    } else {
      No<T> novoNo = new No<T>(valor);
      No<T> noAuxiliar = retornaNo(posicao - 1);
      novoNo.proximo = noAuxiliar.proximo;
      noAuxiliar.proximo = novoNo;
      tamanho++;
    }
  }

  public void removerPosicao(int posicao) {
    if (posicao < 0 || posicao >= tamanho) throw new RuntimeException(
      "A posição " + posicao + " está fora dos limites da lista."
    );
    if (posicao == 0) {
      removerInicio();
    } else if (posicao == tamanho - 1) {
      removerFim();
    } else {
      No<T> noAnterior = retornaNo(posicao - 1);
      No<T> noRemovido = noAnterior.proximo;
      noAnterior.proximo = noRemovido.proximo;
      noRemovido.proximo = null;
      tamanho--;
    }
  }

  public void exibirLista() {
    System.out.print("[");
    No<T> noAuxiliar = inicio;
    while (noAuxiliar != null) {
      System.out.print(noAuxiliar.valor);
      noAuxiliar = noAuxiliar.proximo;
      if (noAuxiliar != null) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}
