public class Car {
    String brand;
    int year ;
    double mileage;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }

    boolean isAntique() {
        int currentYear = 2026;
        return (currentYear - year) > 25;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 2020;
        car1.mileage = 15346.5;

        car1.display();

        Car car2 = new Car();
        car2.brand = "Honda";
        car2.year = 2018;
        car2.mileage = 30470.0;

        car2.display(); 

        Car car3 = new Car();
        car3.brand = "Ford";
        car3.year = 2019;
        car3.mileage = 25063.567;

        car3.display();

        System.out.println(car3.brand + " is an antique? " + car3.isAntique());
    }
}