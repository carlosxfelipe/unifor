package ListaDinamica;

class No<T> {

  T valor;
  No<T> proximo;

  public No(T valor) {
    this.valor = valor;
    proximo = null;
  }

  @Override
  public String toString() {
    return valor.toString();
  }
}
