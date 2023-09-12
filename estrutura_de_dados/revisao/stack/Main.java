public class Main {

  public static void main(String[] args) {
    Pilha<Integer> pilha = new Pilha<>();
    pilha.push(1);
    pilha.push(2);
    pilha.push(3);

    System.out.println("Elemento no topo: " + pilha.peek()); // Elemento no topo: 3
    pilha.exibirPilha(); // 3 -> 2 -> 1 -> null

    int topo = pilha.pop();
    System.out.println("Elemento removido do topo: " + topo); // Elemento removido do topo: 3

    System.out.println("Elemento no topo após remoção: " + pilha.peek()); // Elemento no topo após remoção: 2
    pilha.exibirPilha(); // 2 -> 1 -> null

    System.out.println("Altura da pilha: " + pilha.altura()); // Altura da pilha: 2
  }
}
