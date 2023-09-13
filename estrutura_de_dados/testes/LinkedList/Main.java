import java.util.*;

public class Main {

  public static void main(String[] args) {
    LinkedList<Integer> lista = new LinkedList<>();

    lista.add(1);
    lista.add(2);
    lista.addLast(3);
    lista.addFirst(4);
    lista.add(2, 5);

    System.out.println("Lista original: " + lista);

    if (!lista.isEmpty()) {
      lista.remove(Integer.valueOf(2));
      lista.removeFirst();
      lista.removeLast();
    }

    if (!lista.isEmpty()) {
      Collections.reverse(lista);
    }

    System.out.println("Lista após as remoções e inversão: " + lista);
  }
}
