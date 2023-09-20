import java.util.Scanner;

public class Main {

  public static class Stack<T> {

    private Node<T> top;
    private int height;

    public Stack() {
      top = null;
      height = 0;
    }

    public Stack(T value) {
      Node<T> newNode = new Node<T>(value);
      if (top == null) {
        top = newNode;
      }
      height = 1;
    }

    public void printStack() {
      Node<T> startNode = top;
      while (startNode != null) {
        System.out.println("[" + startNode.value + "]");
        startNode = startNode.next;
      }
    }

    public T pop() {
      if (top == null) {
        throw new RuntimeException("Pila vazia.");
      }
      Node<T> poppedNode = top;
      top = top.next;
      poppedNode.next = null;
      height--;
      return poppedNode.value;
    }

    public void push(T value) {
      Node<T> newNode = new Node<T>(value);
      if (top == null) {
        top = newNode;
      } else {
        newNode.next = top;
        top = newNode;
      }
      height++;
    }

    public T peek() {
      return top.value;
    }

    // novos métodos

    public boolean isEmpty() {
      return top == null;
    }

    public int size() {
      return height;
    }

    public void clear() {
      top = null;
      height = 0;
    }

    public boolean estaBalanceada(String expression) {
      Stack<Character> stack = new Stack<>();

      for (char c : expression.toCharArray()) {
        if (c == '(') {
          stack.push(c);
        } else if (c == ')') {
          if (stack.isEmpty()) {
            return false;
          } else {
            stack.pop();
          }
        }
      }

      return stack.isEmpty(); // vazia = balanceada.
    }

    public String decimalToBinary(int decimal) {
      Stack<Integer> stack = new Stack<>();

      while (decimal > 0) {
        int restante = decimal % 2;
        stack.push(restante);
        decimal /= 2;
      }

      StringBuilder binary = new StringBuilder();

      while (!stack.isEmpty()) {
        binary.append(stack.pop());
      }

      return binary.toString();
    }
  }

  public static class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Stack<Object> minhaPilha = new Stack<>();

    System.out.print("Quantas vezes deseja ler um valor inteiro? ");
    int vezes = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha

    for (int i = 0; i < vezes; i++) {
      System.out.print("Digite um número: ");
      int valor = scanner.nextInt();
      minhaPilha.push(valor);
    }

    System.out.println("Conteúdo da pilha:");
    minhaPilha.printStack();

    String expression1 = "((2 + 3) * (4 - 1))"; // balanceada
    String expression2 = "((2 + 3) * (4 - 1)"; // não balanceada

    System.out.println(
      "Expressão 1 está balanceada? " + minhaPilha.estaBalanceada(expression1)
    );
    System.out.println(
      "Expressão 2 está balanceada? " + minhaPilha.estaBalanceada(expression2)
    );

    System.out.println(minhaPilha.decimalToBinary(10));

    scanner.close();
  }
}
