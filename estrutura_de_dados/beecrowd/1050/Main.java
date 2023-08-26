import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int DDD = scanner.nextInt();

    Map<Integer, String> dddCityNumber = new HashMap<>();
    dddCityNumber.put(61, "Brasilia");
    dddCityNumber.put(71, "Salvador");
    dddCityNumber.put(11, "Sao Paulo");
    dddCityNumber.put(21, "Rio de Janeiro");
    dddCityNumber.put(32, "Juiz de Fora");
    dddCityNumber.put(19, "Campinas");
    dddCityNumber.put(27, "Vitoria");
    dddCityNumber.put(31, "Belo Horizonte");

    String city = dddCityNumber.getOrDefault(DDD, "DDD nao cadastrado");
    System.out.println(city);

    scanner.close();
  }
}
