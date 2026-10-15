class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called for " + name);
    }
}

public class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name); 
        this.breed = breed;
        System.out.println("Dog constructor called for breed " + breed);
    }

    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "Golden Retriever");
        System.out.println("Dog Name: " + d.name + ", Breed: " + d.breed);
        // Example using 'd':
        System.out.println(d.toString());
    }

    
}