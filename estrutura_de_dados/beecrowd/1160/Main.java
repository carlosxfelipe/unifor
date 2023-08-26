import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int casosTeste = scanner.nextInt();

    for (int i = 0; i < casosTeste; i++) {
      int populationA = scanner.nextInt();
      int populationB = scanner.nextInt();
      double growthRateA = scanner.nextDouble();
      double growthRateB = scanner.nextDouble();

      int years = 0;
      while (populationA <= populationB) {
        populationA += (int) (populationA * (growthRateA / 100));
        populationB += (int) (populationB * (growthRateB / 100));
        years++;

        if (years > 100) {
          System.out.println("Mais de 1 seculo.");
          break;
        }
      }

      if (years <= 100) {
        System.out.println(years + " anos.");
      }
    }
    scanner.close();
  }
}
