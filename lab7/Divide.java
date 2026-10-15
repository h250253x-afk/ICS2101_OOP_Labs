import java.util.*;

public class Divide {
    public static void main(String[] args) {
        try (Scanner scan1 = new Scanner(System.in)) {
            try {
                int a = scan1.nextInt();
                int b = scan1.nextInt();
                System.out.println("Result: " + (a / b));
            } catch (InputMismatchException e) {
                System.out.println("Non-numeric input!");
            } catch (ArithmeticException e) {
                System.out.println("Division by zero!");
            }
        }
    }
}
