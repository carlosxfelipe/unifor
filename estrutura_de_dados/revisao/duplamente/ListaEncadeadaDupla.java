import java.lang.IndexOutOfBoundsException;

public class ListaEncadeadaDupla<T> {

  private No<T> inicio;
  private No<T> fim;

  public ListaEncadeadaDupla() {
    this.inicio = null;
    this.fim = null;
  }

  public ListaEncadeadaDupla(T valor) {
    No<T> novoNo = new No<>(valor);
    this.inicio = novoNo;
    this.fim = novoNo;
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
    novoNo.anterior = null;
    if (inicio != null) {
      inicio.anterior = novoNo;
    }
    inicio = novoNo;
    if (fim == null) {
      fim = inicio;
    }
  }

  public void removerInicio() {
    if (inicio != null) {
      inicio = inicio.proximo;
      if (inicio != null) {
        inicio.anterior = null;
      } else {
        fim = null;
      }
    }
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<>(valor);
    novoNo.anterior = fim;
    novoNo.proximo = null;
    if (fim != null) {
      fim.proximo = novoNo;
    }
    fim = novoNo;
    if (inicio == null) {
      inicio = fim;
    }
  }

  public void removerFim() {
    if (fim != null) {
      fim = fim.anterior;
      if (fim != null) {
        fim.proximo = null;
      } else {
        inicio = null;
      }
    }
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
      novoNo.anterior = atual;
      novoNo.proximo = atual.proximo;
      if (atual.proximo != null) {
        atual.proximo.anterior = novoNo;
      }
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
      if (atual == null) {
        throw new IndexOutOfBoundsException("Posição inválida");
      }
      atual = atual.proximo;
      contador++;
    }

    if (atual != null && atual.proximo != null) {
      atual.proximo = atual.proximo.proximo;
      if (atual.proximo != null) {
        atual.proximo.anterior = atual;
      } else {
        fim = atual;
      }
    }
  }

  public void inverterLista() {
    No<T> atual = inicio;
    No<T> temp;

    while (atual != null) {
      // Troca os ponteiros 'anterior' e 'proximo' do nó atual
      temp = atual.anterior;
      atual.anterior = atual.proximo;
      atual.proximo = temp;

      // Move para o próximo nó
      atual = atual.anterior;
    }

    // Troca os ponteiros de início e fim
    temp = inicio;
    inicio = fim;
    fim = temp;
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
    No<T> anterior;
    No<T> proximo;

    No(T valor) {
      this.valor = valor;
      this.anterior = null;
      this.proximo = null;
    }
  }
}
