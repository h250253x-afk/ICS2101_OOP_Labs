class Address {
    String city;
}

class Person {
    Address address;

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.address = new Address();
        p1.address.city = "Harare";

        System.out.println("City: " + p1.address.city);

        Person pNull = new Person();
        if (pNull.address == null) {
            System.out.println("Address is null");
        }
    }

}

