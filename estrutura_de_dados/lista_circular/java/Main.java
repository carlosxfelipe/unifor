package java;

class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class CircularLinkedList {

  private Node head;
  private Node tail;

  public CircularLinkedList() {
    head = null;
    tail = null;
  }

  public void addToEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    tail.next = head; // Conecta o último elemento ao primeiro para formar o loop.
  }

  public void display() {
    if (head == null) {
      System.out.println("A lista está vazia.");
      return;
    }
    Node current = head;
    do {
      System.out.print(current.data + " ");
      current = current.next;
    } while (current != head);
    System.out.println();
  }
}

public class Main {

  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();

    list.addToEnd(1);
    list.addToEnd(2);
    list.addToEnd(3);
    list.addToEnd(4);

    System.out.println("Lista circular:");
    list.display();
  }
}
