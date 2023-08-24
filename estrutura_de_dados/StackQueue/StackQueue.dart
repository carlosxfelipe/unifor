abstract class Stack<T> {
  int size();
  bool isEmpty();
  void push(T value);
  T pop();
  T peek();
  void showElements();
}

abstract class Queue<T> {
  int size();
  bool isEmpty();
  void enqueue(T value);
  T dequeue();
  T first();
  void showElements();
}

class CustomStack<T> implements Stack<T> {
  List<T> stack = [];

  @override
  int size() => stack.length;

  @override
  bool isEmpty() => stack.isEmpty;

  @override
  void push(T value) {
    stack.add(value);
  }

  @override
  T pop() {
    if (isEmpty()) {
      throw StateError("A pilha está vazia");
    }
    return stack.removeLast();
  }

  @override
  T peek() {
    if (isEmpty()) {
      throw StateError("A pilha está vazia");
    }
    return stack.last;
  }

  @override
  void showElements() {
    print(stack.join(', '));
  }
}

class CustomQueue<T> implements Queue<T> {
  List<T> queue = [];

  @override
  int size() => queue.length;

  @override
  bool isEmpty() => queue.isEmpty;

  @override
  void enqueue(T value) {
    queue.add(value);
  }

  @override
  T dequeue() {
    if (isEmpty()) {
      throw StateError("A fila está vazia");
    }
    return queue.removeAt(0);
  }

  @override
  T first() {
    if (isEmpty()) {
      throw StateError("A fila está vazia");
    }
    return queue.first;
  }

  @override
  void showElements() {
    print(queue.join(', '));
  }
}

void main() {
  var stack = CustomStack<int>();
  stack.push(1);
  stack.push(2);
  stack.push(3);
  stack.push(4);
  stack.push(5);
  stack.push(6);

  print("Tamanho da pilha: ${stack.size()}");
  print("Elemento do topo: ${stack.peek()}");
  stack.showElements();

  stack.pop();
  print("Tamanho da pilha após desempilhar: ${stack.size()}");
  stack.showElements();

  print("\n==== Separador entre Pilha e Fila ====\n");

  var queue = CustomQueue<String>();
  queue.enqueue("A");
  queue.enqueue("B");
  queue.enqueue("C");
  queue.enqueue("D");
  queue.enqueue("E");
  queue.enqueue("F");

  print("Tamanho da fila: ${queue.size()}");
  print("Primeiro elemento: ${queue.first()}");
  queue.showElements();

  queue.dequeue();
  print("Tamanho da fila após desenfileirar: ${queue.size()}");
  queue.showElements();
}
