public class Main {

  public static void main(String[] args) {
    Fila<Integer> fila = new Fila<>();

    fila.enfileirar(1);
    fila.enfileirar(2);
    fila.enfileirar(3);

    System.out.println("Elemento na frente: " + fila.verFrente()); // Elemento na frente: 1
    fila.exibirFila(); // 1 <- 2 <- 3 <- null

    int frente = fila.desenfileirar();
    System.out.println("Elemento removido da frente: " + frente); // Elemento removido da frente: 1

    System.out.println("Elemento na frente após remoção: " + fila.verFrente()); // Elemento na frente após remoção: 2
    fila.exibirFila(); // 2 <- 3 <- null
  }
}
