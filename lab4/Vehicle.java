public class Vehicle {
    public Vehicle() {
        System.out.println("Vehicle constructor");
    }

    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar instance...\n");
        new ElectricCar();
    }
}

class Car extends Vehicle {
    public Car() {
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    public ElectricCar() {
        System.out.println("ElectricCar constructor");
    }
}