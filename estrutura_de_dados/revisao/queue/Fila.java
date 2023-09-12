public class Fila<T> {

  private No<T> frente;
  private No<T> tras;

  public Fila() {
    this.frente = null;
    this.tras = null;
  }

  public boolean estaVazia() {
    return frente == null;
  }

  // Insere um elemento no final da fila
  public void enfileirar(T valor) {
    No<T> novoNo = new No<>(valor);

    if (estaVazia()) {
      frente = novoNo;
      tras = novoNo;
    } else {
      tras.proximo = novoNo;
      tras = novoNo;
    }
  }

  // Remove e retorna o elemento da frente da fila
  public T desenfileirar() {
    if (estaVazia()) {
      throw new IllegalStateException("A fila está vazia");
    }

    T valorFrente = frente.valor;
    frente = frente.proximo;

    if (frente == null) {
      tras = null; // Se a fila ficou vazia após a remoção, atualize 'tras' também.
    }

    return valorFrente;
  }

  // Retorna o elemento da frente da fila sem removê-lo
  public T verFrente() {
    if (estaVazia()) {
      throw new IllegalStateException("A fila está vazia");
    }

    return frente.valor;
  }

  public void inverterFila() {
    if (estaVazia()) {
      return; // Se a fila estiver vazia, não há nada para inverter
    }

    No<T> anterior = null;
    No<T> atual = frente;
    No<T> proximo;

    while (atual != null) {
      proximo = atual.proximo;
      atual.proximo = anterior;
      anterior = atual;
      atual = proximo;
    }

    // Inverter 'frente' e 'tras'
    No<T> temp = frente;
    frente = tras;
    tras = temp;
  }

  public void exibirFila() {
    No<T> atual = frente;

    while (atual != null) {
      System.out.print(atual.valor + " <- ");
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
