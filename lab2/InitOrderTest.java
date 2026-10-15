public class InitOrderTest {
    static { System.out.println("Static block 1"); }
    static { System.out.println("Static block 2"); }

    { System.out.println("Instance block 1"); }
    { System.out.println("Instance block 2"); }

    public InitOrderTest() {
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
        
        System.out.println("\n--- Creating First Object ---");
        new InitOrderTest();

        System.out.println("\n--- Creating Second Object ---");
        new InitOrderTest();
    }
}
