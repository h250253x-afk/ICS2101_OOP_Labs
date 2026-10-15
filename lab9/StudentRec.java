public record StudentRec(String name, int age) {
    public static void main(String[] args) {
        StudentRec s1 = new StudentRec("Israel", 20);
        StudentRec s2 = new StudentRec("Israel", 20);
        System.out.println(s1);
        System.out.println("Equals? " + s1.equals(s2));
        System.out.println("Name: " + s1.name());
    }
}

