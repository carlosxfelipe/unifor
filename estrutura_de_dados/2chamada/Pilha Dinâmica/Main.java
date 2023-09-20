// import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);

    Stack<Object> minhaPilha = new Stack<>();

    minhaPilha.push(10);
    minhaPilha.push(20);
    minhaPilha.push(30);

    // minhaPilha.printStack();

    String expression1 = "((2 + 3) * (4 - 1))"; // balanceada
    String expression2 = "((2 + 3) * (4 - 1)"; // não balanceada

    System.out.println(minhaPilha.estaBalanceada(expression1)); // true
    System.out.println(minhaPilha.estaBalanceada(expression2)); // false

    int valorDecimal = 10;
    System.out.println(minhaPilha.decimalToBinary(10));
  }
}
