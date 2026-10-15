interface Flyable { 
    void fly(); 
}
class Bird implements Flyable { 
    public void fly() { 
        System.out.println("Bird flying"); 
    } 
}
class Aeroplane implements Flyable { 
    public void fly() { 
        System.out.println("Plane flying"); 
    } 
}
