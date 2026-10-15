import java.util.Arrays;

public class Printer {
    public void print(int value) {
        System.out.println("Printing int: " + value);
    }

    public void print(double value) {
        System.out.printf("Printing double: %.2f%n", value);
    }

    public void print(String value) {
        System.out.println("Printing String: " + value);
    }

    public void print(int[] numbers) {
        System.out.println("Printing int array: " + Arrays.toString(numbers));
    }

    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.print(42);
        printer.print(3.14159);
        printer.print("Hello, Object-Oriented Programming!");
        printer.print(new int[]{10, 20, 30, 40, 50});
    }
}