public class TesteCachorro {

  public static void main(String[] args) {
    Cachorro objeto = new Cachorro("Totó", "Doroty");

    objeto.altura = 0.80f;
    objeto.peso = 18f;

    objeto.mostrarDetalhes();
  }
}
