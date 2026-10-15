class Parent {
    String value = "Parent Field";
    void getValue() { System.out.println("Parent Method"); }
}
class Child extends Parent {
    String value = "Child Field";
    @Override void getValue() { System.out.println("Child Method"); }
}

public class PolyTest {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.value); // Prints "Parent Field"
        p.getValue();               // Prints "Child Method"
    }
}
