class ListaEncadeadaSimples<T> {
  No<T>? inicio;
  No<T>? fim;
  int tamanho = 0;

  ListaEncadeadaSimples() {
    tamanho = 0;
    inicio = null;
    fim = null;
  }

  ListaEncadeadaSimples.inicial(T valor) {
    No<T> novoNo = No(valor);
    inicio = novoNo;
    fim = novoNo;
    tamanho = 1;
  }

  T retornaValor(int posicao) {
    return retornaNo(posicao).valor;
  }

  No<T> retornaNo(int posicao) {
    if (inicio == null) {
      throw Exception("Lista está vazia!");
    } else if (posicao < 0 || posicao >= tamanho) {
      throw Exception("Posição $posicao está fora dos limites da lista");
    }
    No<T>? noAuxiliar = inicio;
    for (int i = 0; i < posicao; i++) {
      noAuxiliar = noAuxiliar?.proximo;
    }
    return noAuxiliar!;
  }

  void inserirInicio(T valor) {
    No<T> novoNo = No(valor);
    if (inicio == null) {
      inicio = novoNo;
      fim = novoNo;
    } else {
      novoNo.proximo = inicio;
      inicio = novoNo;
    }
    tamanho++;
  }

  void removerInicio() {
    if (tamanho == 0)
      throw Exception("A lista está vazia. Não é possível remover o início.");

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      var noAuxiliar = inicio;
      inicio = noAuxiliar?.proximo;
      noAuxiliar?.proximo = null;
    }
    tamanho--;
  }

  void inserirFim(T valor) {
    No<T> novoNo = No(valor);
    if (inicio == null) {
      inicio = novoNo;
    } else {
      fim?.proximo = novoNo;
    }
    fim = novoNo;
    tamanho++;
  }

  void removerFim() {
    if (tamanho == 0)
      throw Exception("A lista está vazia. Não é possível remover o fim.");

    if (tamanho == 1) {
      inicio = null;
      fim = null;
    } else {
      var noAnterior = retornaNo(tamanho - 2);
      noAnterior.proximo = null;
      fim = noAnterior;
    }
    tamanho--;
  }

  void inserirPosicao(int posicao, T valor) {
    if (posicao <= 0) {
      inserirInicio(valor);
    } else if (posicao >= tamanho) {
      inserirFim(valor);
    } else {
      No<T> novoNo = No(valor);
      No<T> noAuxiliar = retornaNo(posicao - 1);
      novoNo.proximo = noAuxiliar.proximo;
      noAuxiliar.proximo = novoNo;
      tamanho++;
    }
  }

  void removerPosicao(int posicao) {
    if (posicao < 0 || posicao >= tamanho)
      throw Exception("A posição $posicao está fora dos limites da lista.");
    if (posicao == 0) {
      removerInicio();
    } else if (posicao == tamanho - 1) {
      removerFim();
    } else {
      var noAnterior = retornaNo(posicao - 1);
      noAnterior.proximo = noAnterior.proximo?.proximo;
      tamanho--;
    }
  }

  void exibirLista() {
    String listaString = "[";
    No<T>? noAuxiliar = inicio;
    while (noAuxiliar != null) {
      listaString += "${noAuxiliar.valor}";
      noAuxiliar = noAuxiliar.proximo;
      if (noAuxiliar != null) {
        listaString += ", ";
      }
    }
    listaString += "]";
    print(listaString);
  }
}

class No<T> {
  T valor;
  No<T>? proximo;

  No(T valor) : valor = valor {
    this.valor = valor;
    proximo = null;
  }
}

void main() {
  ListaEncadeadaSimples<int> lista = ListaEncadeadaSimples<int>();

  lista.inserirInicio(1);
  lista.inserirFim(2);
  lista.inserirFim(3);
  lista.inserirPosicao(1, 4);
  lista.removerInicio();
  lista.removerFim();
  lista.removerPosicao(1);

  // print("Elemento na posição 2: ${lista.retornaValor(2)}");

  lista.exibirLista();
}