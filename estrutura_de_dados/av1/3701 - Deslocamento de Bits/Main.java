import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    ListaDuplamenteEncadeada<Object> byteDLL = new ListaDuplamenteEncadeada<>();
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String op;
    for (int i = 0; i < 8; i++) {
      byteDLL.inserirFim(sc.nextInt());
    }

    for (int i = 0; i < N; i++) {
      op = sc.next();
      if (op.equals("esquerda")) {
        byteDLL.deslocarEsquerda();
      } else {
        byteDLL.deslocarDireita();
      }
    }
    byteDLL.exibirLista();
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

  public void exibirLista() {
    No<T> noAux = inicio;
    for (int i = 0; i < tamanho; i++) {
      System.out.print(noAux.valor);
      noAux = noAux.proximo;
    }
    System.out.println();
  }

  public void inserirFim(T valor) {
    No<T> novoNo = new No<>(valor);
    if (inicio == null) {
      inicio = novoNo;
    } else {
      novoNo.anterior = fim;
      fim.proximo = novoNo;
    }

    fim = novoNo;
    fim.proximo = inicio;
    inicio.anterior = fim;
    tamanho++;
  }

  public void deslocarDireita() {
    inicio = fim;
    fim = fim.anterior;
  }

  public void deslocarEsquerda() {
    fim = inicio;
    inicio = inicio.proximo;
  }
}
