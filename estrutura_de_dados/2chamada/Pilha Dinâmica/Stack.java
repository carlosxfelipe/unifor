public class Stack<T> {

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
