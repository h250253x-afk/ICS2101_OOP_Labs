public class FinallyReturn {
    static int test() {
        try {
            return 1;
        } finally {
            System.out.println("Finally block executed");
        }
    }
    public static void main(String[] args) {
        System.out.println("Returned: " + test());
    }
}