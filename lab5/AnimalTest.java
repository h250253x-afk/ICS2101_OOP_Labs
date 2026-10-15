class Animal {
    void sound() {
        System.out.println("Sound"); }
}
class Cat extends Animal { void sound() { 
    System.out.println("Meow"); 
    } 
}

class Cow extends Animal { void sound() { 
    System.out.println("Moo"); 
    } 
}

class Duck extends Animal { void sound() { 
    System.out.println("Quack"); 
    } 
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = { new Cat(), new Cow(), new Duck() };
        for (Animal a : animals) a.sound();
    }
}
