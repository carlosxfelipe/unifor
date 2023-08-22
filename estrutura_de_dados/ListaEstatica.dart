void main() {
  ListaEstatica<int> listaEstatica = ListaEstatica<int>(10);
  listaEstatica.inserirFinal(2);
  listaEstatica.exibirLista();
  listaEstatica.inserirFinal(5);
  listaEstatica.exibirLista();
  listaEstatica.inserirInicio(7);
  listaEstatica.exibirLista();
  listaEstatica.inserirPosicao(1, 10);
  listaEstatica.exibirLista();
}

class ListaEstatica<T> implements Lista<T> {
  late List<T> lista;
  late int quantidadeElementos;

  ListaEstatica(int tamanho) {
    lista = List<T>.filled(tamanho, 0 as T);
    quantidadeElementos = 0;
  }

  @override
  bool estaCheia() {
    return quantidadeElementos == lista.length;
  }

  @override
  bool estaVazia() {
    return quantidadeElementos == 0;
  }

  @override
  void exibirLista() {
    if (estaVazia()) {
      throw ListaVaziaException("A lista está vazia!");
    }
    print("[${lista.sublist(0, quantidadeElementos).join(', ')}]");
  }

  @override
  void inserirFinal(T valor) {
    if (estaCheia()) {
      throw ListaCheiaException("A lista está cheia!");
    }

    lista[quantidadeElementos] = valor;
    quantidadeElementos++;
  }

  @override
  void inserirInicio(T valor) {
    if (estaCheia()) {
      throw ListaCheiaException("A lista está cheia!");
    }

    for (int i = quantidadeElementos; i > 0; i--) {
      lista[i] = lista[i - 1];
    }
    lista[0] = valor;
    quantidadeElementos++;
  }

  @override
  void inserirPosicao(int posicao, T valor) {
    if (estaCheia()) {
      throw ListaCheiaException("A lista está cheia!");
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

  @override
  int tamanho() {
    return quantidadeElementos;
  }
}

abstract class Lista<T> {
  int tamanho();
  bool estaVazia();
  bool estaCheia();
  void inserirInicio(T valor);
  void inserirFinal(T valor);
  void inserirPosicao(int posicao, T valor);
  void exibirLista();
}

class ListaVaziaException implements Exception {
  String mensagem;

  ListaVaziaException(this.mensagem);
}

class ListaCheiaException implements Exception {
  String mensagem;

  ListaCheiaException(this.mensagem);
}
