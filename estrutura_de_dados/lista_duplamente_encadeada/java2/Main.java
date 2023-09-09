class Node {

  int data;
  Node prev;
  Node next;

  public Node(int data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class DoublyLinkedList {

  private Node head;
  private Node tail;

  public DoublyLinkedList() {
    head = null;
    tail = null;
  }

  // Inserir no final
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  // Inserir no início
  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  // Remover do final
  public void removeFromEnd() {
    if (tail == null) {
      return; // A lista está vazia
    }
    if (head == tail) {
      head = null;
      tail = null;
      return; // Havia apenas um elemento na lista
    }
    tail = tail.prev;
    tail.next = null;
  }

  // Remover do início
  public void removeFromBeginning() {
    if (head == null) {
      return; // A lista está vazia
    }
    if (head == tail) {
      head = null;
      tail = null;
      return; // Havia apenas um elemento na lista
    }
    head = head.next;
    head.prev = null;
  }

  // Remover da posição específica
  public void removeAtPosition(int position) {
    if (head == null || position < 0) {
      return; // A lista está vazia ou a posição é inválida
    }
    if (position == 0) {
      removeFromBeginning();
      return;
    }

    Node current = head;
    int index = 0;

    while (current != null && index < position) {
      current = current.next;
      index++;
    }

    if (current == null) {
      return; // A posição está além do tamanho da lista
    }

    if (current == tail) {
      removeFromEnd();
    } else {
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
  }

  public void display() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
}

public class Main {

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();

    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);
    list.insertAtEnd(4);

    System.out.println("Lista duplamente encadeada:");
    list.display();

    list.insertAtBeginning(0);
    System.out.println("Após inserção no início:");
    list.display();

    list.removeFromEnd();
    System.out.println("Após remoção do final:");
    list.display();

    list.removeAtPosition(2);
    System.out.println("Após remoção da posição 2:");
    list.display();
  }
}
