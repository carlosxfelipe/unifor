class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {

  private Node head;

  public LinkedList() {
    head = null;
  }

  // Inserir no final
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // Inserir no início
  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  // Remover do início
  public void removeFromBeginning() {
    if (head != null) {
      head = head.next;
    }
  }

  // Remover do final
  public void removeFromEnd() {
    if (head == null || head.next == null) {
      head = null;
      return;
    }

    Node current = head;
    while (current.next.next != null) {
      current = current.next;
    }
    current.next = null;
  }

  // Remover da posição específica
  public void removeAtPosition(int position) {
    if (position < 0 || head == null) {
      return;
    }

    if (position == 0) {
      removeFromBeginning();
      return;
    }

    Node current = head;
    int index = 0;

    while (current != null && index < position - 1) {
      current = current.next;
      index++;
    }

    if (current == null || current.next == null) {
      return;
    }

    current.next = current.next.next;
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
    LinkedList list = new LinkedList();

    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);
    list.insertAtEnd(4);

    System.out.println("Lista encadeada simples:");
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
