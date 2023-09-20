public class Pilha<T> {

  private No<T> topo;

  public Pilha() {
    this.topo = null;
  }

  public boolean estaVazia() {
    return topo == null;
  }

  // Insere um elemento no topo da pilha
  public void push(T valor) {
    No<T> novoNo = new No<>(valor);
    novoNo.proximo = topo;
    topo = novoNo;
  }

  // Remove e retorna o elemento do topo da pilha
  public T pop() {
    if (estaVazia()) {
      throw new IllegalStateException("A pilha está vazia");
    }

    T valorTopo = topo.valor;
    topo = topo.proximo;
    return valorTopo;
  }

  // Retorna o elemento do topo da pilha sem removê-lo
  public T peek() {
    if (estaVazia()) {
      throw new IllegalStateException("A pilha está vazia");
    }

    return topo.valor;
  }

  public int altura() {
    int altura = 0;
    No<T> atual = topo;

    while (atual != null) {
      altura++;
      atual = atual.proximo;
    }

    return altura;
  }

  public void inverterPilha() {
    if (estaVazia()) {
      return;
    }

    No<T> prev = null;
    No<T> atual = topo;
    No<T> proximo;

    while (atual != null) {
      proximo = atual.proximo;
      atual.proximo = prev;
      prev = atual;
      atual = proximo;
    }

    topo = prev; // O topo agora será o último elemento, invertendo a pilha
  }

  public void exibirPilha() {
    No<T> atual = topo;

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