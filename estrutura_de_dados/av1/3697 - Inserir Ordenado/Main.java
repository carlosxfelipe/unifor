import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ListaDuplamenteEncadeada<Object> primos = new ListaDuplamenteEncadeada<>();
    ListaDuplamenteEncadeada<Object> naoPrimos = new ListaDuplamenteEncadeada<>();

    int e;
    do {
      e = sc.nextInt();
      if (e > 0) {
        if (ehPrimo(e)) {
          primos.inserirOrdenado(e);
        } else {
          naoPrimos.inserirOrdenado(e);
        }
      }
    } while (e >= 0);
    sc.close();

    if (primos.getTamanho() == 0 || naoPrimos.getTamanho() == 0) {
      System.out.println("Uma das estruturas está vazia!");
    } else {
      primos.exibirLista();
      System.out.println("-");
      naoPrimos.exibirReverso();
    }
  }

  public static boolean ehPrimo(int n) {
    if (n <= 1) {
      return false;
    }
    int c = 1;
    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        c++;
        if (c > 2) {
          return false;
        }
      }
    }
    return true;
  }
}

class No<T> {

  T valor;
  No<T> proximo;
  No<T> anterior;

  public No(T valor) {
    this.valor = valor;
    proximo = null;
    anterior = null;
  }
}

class ListaDuplamenteEncadeada<T> {

  private No<T> inicio;
  private No<T> fim;
  private int tamanho;

  public ListaDuplamenteEncadeada() {
    tamanho = 0;
    inicio = null;
    fim = null;
  }

  public int getTamanho() {
    return tamanho;
  }

  public ListaDuplamenteEncadeada(T valor) {
    No<T> novoNo = new No<T>(valor);
    inicio = novoNo;
    fim = novoNo;
    tamanho = 1;
  }

  public void exibirReverso() {
    No<T> noAux = fim;
    while (noAux != null) {
      System.out.println(noAux.valor);
      noAux = noAux.anterior;
    }
  }

  public void exibirLista() {
    No<T> noAux = inicio;
    while (noAux != null) {
      System.out.println(noAux.valor);
      noAux = noAux.proximo;
    }
  }

  public T retornaValor(int posicao) {
    return retornarNo(posicao).valor;
  }

  private No<T> retornarNo(int posicao) {
    if (posicao < 0 || posicao >= tamanho) {
      throw new IndexOutOfBoundsException(
        "Posição " + posicao + " está fora dos limites!"
      );
    }
    No<T> noAux;
    if (posicao < tamanho / 2) {
      noAux = inicio;
      for (int i = 0; i < posicao; i++) {
        noAux = noAux.proximo;
      }
    } else {
      noAux = fim;
      for (int i = tamanho - 1; i > posicao; i--) {
        noAux = noAux.anterior;
      }
    }

    return noAux;
  }

  public void inserirInicio(T valor) {
    No<T> novoNo = new No<>(valor);
    if (inicio == null) {
      inicio = novoNo;
      fim = novoNo;
    } else {
      novoNo.proximo = inicio;
      inicio.anterior = novoNo;
      inicio = novoNo;
    }
    tamanho++;
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<>(valor);

    if (inicio == null) {
      inicio = novoNo;
    } else {
      fim.proximo = novoNo;
      novoNo.anterior = fim;
    }
    fim = novoNo;
    tamanho++;
  }

  public void inserirOrdenado(T valor) {
    if (inicio == null) {
      inserirFim(valor);
    } else {
      if ((Integer) valor >= (Integer) fim.valor) {
        inserirFim(valor);
      } else if ((Integer) valor <= (Integer) inicio.valor) {
        inserirInicio(valor);
      } else {
        No<T> novoNo = new No<>(valor);
        No<T> noAux = inicio;
        while ((Integer) novoNo.valor > (Integer) noAux.valor) {
          noAux = noAux.proximo;
        }

        novoNo.proximo = noAux;
        novoNo.anterior = noAux.anterior;
        noAux.anterior.proximo = novoNo;
        noAux.anterior = novoNo;
        tamanho++;
      }
    }
  }

  public void inserirPosicao(int posicao, T valor) {
    if (posicao <= 0) {
      inserirInicio(valor);
    } else if (posicao >= tamanho) {
      inserirFim(valor);
    } else {
      No<T> novoNo = new No<>(valor);
      No<T> noAux = retornarNo(posicao);
      novoNo.proximo = noAux;
      novoNo.anterior = noAux.anterior;
      noAux.anterior.proximo = novoNo;
      noAux.anterior = novoNo;
      tamanho++;
    }
  }
}
